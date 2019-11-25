package com.yjjk.erp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.Info.ManangerUserModel;

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
	public List<ManangerUserModel> ManagerList(@Valid ManangerUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 新增管理员
	 * 
	 * @param userModel
	 * @return
	 */
	public String addManager(@Valid ManangerUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 删除管理员
	 * 
	 * @param userModel
	 * @return
	 */
	public String deleteManager(@Valid ManangerUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 编辑管理员
	 * 
	 * @param userModel
	 * @return
	 */
	public String updateManager(@Valid ManangerUserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	






}
