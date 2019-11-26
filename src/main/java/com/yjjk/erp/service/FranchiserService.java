package com.yjjk.erp.service;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.wx.WechatModel;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取经销商个人信息
	 * 
	 * @return
	 */
	public CommonResult getfranchiserInfo(Integer franchiserId) {
		FranchiserUserModel user = franchiserDao.getfranchiserInfo(franchiserId);
		return null;
	}

	/**
	 * 新增经销商
     * 
     * @param userModel
     * @return
	 */
	public CommonResult addFran( FranchiserUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取经销商列表
	 * 
	 * @return
	 */
	public List<FranchiserUserModel> getFranList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 小程序退出登录
	 * 
	 * @return
	 */
	public boolean XCXLoginOut( FranchiserUserModel userModel) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 获取与经销商无关的公司列表
	 * 
	 * @return
	 */
	public List<ContractInfo> getCompanyList(Integer id) {
		return companyDao.getCompanyList(id);
	}


	
	}
