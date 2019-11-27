package com.yjjk.erp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.ListData;
import com.yjjk.erp.entity.Info.ManageAccountModel;
import com.yjjk.erp.entity.Info.ManagePassword;
import com.yjjk.erp.entity.Info.ManangerUserModel;
import com.yjjk.erp.entity.Info.YjLoginState;
import com.yjjk.erp.utility.MD532;
import com.yjjk.erp.utility.PasswordUtils;
import com.yjjk.erp.utility.ResultUtil;

/**
 * @program: YjjkErp
 * @description: 管理员
 * @author: CentreS
 * @create: 2019-11-25 19:45:09
 **/
@Service
public class ManagerService extends SmallBaseService {

	
	/**
	 * 获取管理员列表
	 * 
	 * @param userModel
	 * @return
	 */
	public ListData managerList(CurrencyModel userModel) {
		userModel.setStart(userModel.getPage()*userModel.getNumber());
		userModel.setEnd((userModel.getPage()+1)*userModel.getNumber()-1);
		List<ManangerUserModel> list = managerDao.managerList(userModel);
		for (ManangerUserModel manangerUserModel : list) {
			String b =manangerUserModel.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			manangerUserModel.setPhone(b);
		}
		ListData listData = new ListData();
		listData.setData(list);
		listData.setTotal(managerDao.getmanagerNum());
		return listData;
	}
	
	/**
	 * 获取管理员名称和id
	 * 
	 * @return
	 */
	public List<ManangerUserModel> getManager() {
		List<ManangerUserModel> list = managerDao.getManager();
		return list;
	}
	
	/**
	 * 新增管理员
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public void addManager( ManangerUserModel userModel) {
		userModel.setPassWord(MD532.encode("123456"));
		managerDao.addManager(userModel);
	}
	
	/**
	 * 删除管理员
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public void deleteManager(Integer id) {
		managerDao.deleteManager(id);
		
	}
	
	/**
	 * 编辑管理员
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public void updateManager(Integer userId,Integer roleId) {
		ManangerUserModel userModel = new ManangerUserModel();
		userModel.setManagerId(userId);
		userModel.setGender(roleId);
		userModel.setUpdateTime(getAllTime());
		managerDao.updateManager(userModel);
	}
	
	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public List<ManangerUserModel> RoleList() {
		
		return managerDao.RoleList();
	}
	
	/**
	 * 管理员修改密码
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public CommonResult ChangeManagerPassWord(ManagePassword managePassword) {
		ManangerUserModel manager = managerDao.getManagerData(managePassword.getUserId());
		String PassWord = MD532.encode(managePassword.getPassWord());
		if(manager.getPassWord().equals(PassWord)){
			manager.setUpdateTime(getAllTime());
			manager.setPassWord(MD532.encode(managePassword.getNewPassWord()));
			managerDao.ChangeManagerPassWord(manager);
			return  ResultUtil.returnSuccess("");
		}else{
			return ResultUtil.returnError("300", "旧密码错误");
		}
	}
	
	/**
	 * 管理员登录
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public CommonResult loginManager(ManageAccountModel accountModel,HttpServletRequest request) {
		Integer id = managerDao.getManagerPassWord(accountModel.getPhone());
		if(id == null){
			return ResultUtil.returnError("300", "账号不存在");
		}
		ManangerUserModel manager = managerDao.getManagerData(id);
		String newPassWord = MD532.encode(accountModel.getPassword());
		if(manager.getPassWord().equals(newPassWord)){
			String token = checkToken(request,manager.getManagerId());
			manager.setPassWord("");
			manager.setToken(token);
			return  ResultUtil.returnSuccess(manager);
		}else{
			return ResultUtil.returnError("300", "密码错误");
		}
		
		
		
	}

	/**
	 * 确认账号是否存在
	 * 
	 * @param account
	 * @return
	 */
	@Transactional
	public CommonResult checkAccount(String account) {
		Integer id = managerDao.getManagerPassWord(account);
		if(id == null){
			return  ResultUtil.returnSuccess("");
		}else{
			return ResultUtil.returnError("300", "该账号已存在");
		}
	}

	/**
	 * 确认Token是否存在
	 * 
	 * @param account
	 * @return
	 */
	public boolean checkToken(String token, String remoteAddr) {
		String id = managerDao.checkToken(token,remoteAddr);
		if(id !=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 登录更新token
	 * 
	 * @param account
	 * @return
	 */
	@Transactional
	public String checkToken(HttpServletRequest request, Integer managerId) {
        YjLoginState loginState = managerDao.getTokeInfo(managerId);
        String token = "";
        if (loginState != null) {
        	loginState.setLoginOutTime(getAllTime());
        	loginState.setStatus(0);
        	loginState.setIp(request.getRemoteAddr());
            managerDao.updateTokenInfo(loginState);
            token = loginState.getToken();
        } else {
            // 生成登录信息
            loginState = new YjLoginState();
            token = PasswordUtils.salt();
            loginState.setLoginOutTime(getAllTime());
            loginState.setToken(token);
            loginState.setIp(request.getRemoteAddr());
            loginState.setManagerId(managerId);
            loginState.setStatus(0);
            managerDao.addTokenInfo(loginState);
        }
        return token;
	}
	
	/**
	 * 管理员退出
	 * 
	 * @param userModel
	 * @return
	 */
	public CommonResult outManager(Integer managerId) {
		 YjLoginState loginState = managerDao.getTokeInfo(managerId);
		 if (loginState != null) {
	        	loginState.setStatus(1);
	        	loginState.setLoginOutTime(getAllTime());
	            managerDao.updateTokenInfo(loginState);
	            return  ResultUtil.returnSuccess("","登出成功");
	        }else{
	        	return ResultUtil.returnError("300", "登出失败");
	        } 
		
	}


	
	
}
