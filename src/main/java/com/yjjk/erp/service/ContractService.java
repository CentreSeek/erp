package com.yjjk.erp.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.FranchiserUserModel;

/**
 * @program: YjjkErp
 * @description: 签约
 * @author: CentreS
 * @create: 2019-11-25 19:42:20
 **/
@Service
public class ContractService extends SmallBaseService {

	/**
	 * 获取签约列表
	 * 
	 * @param userModel
	 * @return
	 */
	public String ManagerList(@Valid ContractInfo userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增签约
	 * 
	 * @param userModel
	 * @return
	 */
	public String addManager(@Valid ContractInfo userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 修改签约
	 * 
	 * @param userModel
	 * @return
	 */
	public String updateManager(@Valid ContractInfo userModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
