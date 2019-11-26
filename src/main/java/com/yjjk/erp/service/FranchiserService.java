package com.yjjk.erp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.wx.WechatModel;
import com.yjjk.erp.utility.MD532;
import com.yjjk.erp.utility.ResultUtil;
import com.yjjk.erp.utility.wx.WebClientUtil;

/**
 * @program: YjjkErp
 * @description: 经销商
 * @author: CentreS
 * @create: 2019-11-25 19:44:25
 **/
@Service
public class FranchiserService extends SmallBaseService {
	
	/**
	 * 获取微信唯一code
	 * 
	 * @param
	 * @return
	 */
	public WechatModel getOpenID(String code) {
		Gson gson = new Gson();
		String weCode = code;
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		HashMap<String, String> params = new HashMap<>();
		params.put("appid", configure.getAppid());
		params.put("secret", configure.getAppSecret());
		params.put("js_code", weCode);
		params.put("grant_type", configure.getType());
		String rtnStr = null;
		WechatModel wechatModel = new WechatModel();
		try {
			rtnStr = WebClientUtil.doGet(url, params);
			wechatModel = gson.fromJson(rtnStr, WechatModel.class);

		} catch (Exception e) {
			e.printStackTrace();
			wechatModel.setErrmsg(e.toString());
		}

		return wechatModel;
	}

	/**
	 * 经销商账户绑定公司
	 * 
	 * @return
	 */
	public void FranBindingCom(FranchiserUserModel userModel) {
		for (Integer companyId : userModel.getComList()) {
			franchiserDao.addRelation(companyId,userModel.getFranchiserId());
		}
		
	}

	/**
	 * 小程序登录
	 * 
	 * @return
	 */
	public CommonResult XCXLogin( FranchiserUserModel userModel) {
		FranchiserUserModel fran = franchiserDao.checkUser(userModel.getPhone());
			if (fran != null) {
				String userPassword = MD532.encode(userModel.getPassword());
				if (userPassword.equals(fran.getPassword())) {
					fran.setOpenId(userModel.getOpenId());
					Integer id = franchiserDao.checkisLogin(userModel.getOpenId());
					if (id == null) {
						fran.setCreateTime(getAllTime());
						franchiserDao.addNewUserToOpenId(fran);
					} else {
						fran.setUpdateTime(getAllTime());
						franchiserDao.updateUserToOpenId(fran);
					}
					
					return getfranchiserInfo(id);
				} else {
					return ResultUtil.returnError("300","密码错误");
				}
			}else{
				return ResultUtil.returnError("300","该账号不存在");
			}
			
	}
	
	/**
	 * 获取经销商个人信息
	 * 
	 * @return
	 */
	public CommonResult getfranchiserInfo(Integer franchiserId) {
		FranchiserUserModel user = franchiserDao.getfranchiserInfo(franchiserId);
		return ResultUtil.returnSuccess(user);
	}

	/**
	 * 新增经销商
     * 
     * @param userModel
     * @return
	 */
	public CommonResult addFran( FranchiserUserModel userModel) {
		userModel.setPassword(MD532.encode("123456"));
		franchiserDao.addFran(userModel);
		return ResultUtil.returnSuccess("");
	}

	/**
	 * 获取经销商列表
	 * 
	 * @return
	 */
	public List<FranchiserUserModel> getFranList(CurrencyModel userModel) {
		userModel.setStart(userModel.getPage()*userModel.getNumber());
		userModel.setEnd((userModel.getPage()+1)*userModel.getNumber()-1);
		List<FranchiserUserModel> list = franchiserDao.getFranList(userModel) ;
		for (FranchiserUserModel franchiserUserModel : list) {
			String b =franchiserUserModel.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
			franchiserUserModel.setPhone(b);
		}
		return list;
	}
	
	/**
	 * 小程序退出登录
	 * 
	 * @return
	 */
	public boolean XCXLoginOut( FranchiserUserModel userModel) {
		userModel.setUpdateTime(getAllTime());
		userModel.setFranchiserId(0);
		franchiserDao.updateUserToOpenId(userModel);
		return true;
	}
	
	/**
	 * 获取与经销商无关的公司列表
	 * 
	 * @return
	 */
	public List<ContractInfo> getCompanyList(Integer id) {
		return companyDao.getCompanyList(id);
	}

	/**
	 * 经销商停用
	 * 
	 * @return
	 */
	public void updateFran(Integer id) {
		franchiserDao.updateFran(id);
		
	}

	/**
	 * 检查该用户是否登陆过登录
	 * 
	 * @return
	 */
	@Transactional
	public CommonResult checkLogin(String openId) {
		Integer userId = franchiserDao.checkisLogin(openId);
		if (userId == null) {
			return ResultUtil.returnError("300","这是一个新账户");
		} else if (userId == 0){
			return ResultUtil.returnError("300","这是一个新账户");
		}else{
			return getfranchiserInfo(userId);
		}

	}
	
	/**
	 * 确认手机号是否存在
	 * 
	 * @return
	 */
	public boolean checkPhone(String phone) {
		FranchiserUserModel fran = franchiserDao.checkUser(phone);
		if(fran == null){
			return true;
		}else{
			return false;
		}
		
	}
	
	}
