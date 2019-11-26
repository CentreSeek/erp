package com.yjjk.erp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.ManangerUserModel;
import com.yjjk.erp.utility.MD532;
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
	public List<ManangerUserModel> managerList(CurrencyModel userModel) {
		userModel.setStart(userModel.getPage()*userModel.getNumber());
		userModel.setEnd((userModel.getPage()+1)*userModel.getNumber()-1);
		List<ManangerUserModel> list = managerDao.managerList(userModel);
		for (ManangerUserModel manangerUserModel : list) {
			String b =manangerUserModel.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			manangerUserModel.setPhone(b);
		}
		return list;
	}
	
	/**
	 * 新增管理员
	 * 
	 * @param userModel
	 * @return
	 */
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
	public void deleteManager(Integer id) {
		managerDao.deleteManager(id);
		
	}
	
	/**
	 * 编辑管理员
	 * 
	 * @param userModel
	 * @return
	 */
	public void updateManager( ManangerUserModel userModel) {
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
	public CommonResult ChangeManagerPassWord(ManangerUserModel userModel) {
		ManangerUserModel manager = managerDao.getManagerData(userModel.getManagerId());
		String newPassWord = MD532.encode(userModel.getPassWord());
		if(manager.getPassWord().equals(newPassWord)){
			userModel.setUpdateTime(getAllTime());
			userModel.setPassWord(newPassWord);
			managerDao.ChangeManagerPassWord(userModel);
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
	public CommonResult loginManager( ManangerUserModel userModel) {
		String passWord = managerDao.getManagerPassWord(userModel.getPhone());
		String newPassWord = MD532.encode(userModel.getPassWord());
		if(passWord.equals(newPassWord)){
			return  ResultUtil.returnSuccess("");
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
	public CommonResult checkAccount(String account) {
		String passWord = managerDao.getManagerPassWord(account);
		if(passWord == null){
			return  ResultUtil.returnSuccess("");
		}else{
			return ResultUtil.returnError("300", "该账号已存在");
		}
	}
	






}
