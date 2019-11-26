package com.yjjk.erp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
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
	public List<ContractInfo> contractList(CurrencyModel userModel) {
		userModel.setStart(userModel.getPage()*userModel.getNumber());
		userModel.setEnd((userModel.getPage()+1)*userModel.getNumber()-1);
		List<ContractInfo> list = contractDao.contractList(userModel);
		for (ContractInfo contractInfo : list) {
			contractInfo.setStartDate(contractInfo.getStartDate()+"----"+contractInfo.getEndDate());
		}
		return list;
	}

	/**
	 * 新增签约
	 * 
	 * @param userModel
	 * @return
	 */
	public void addContract(ContractInfo userModel) {
		Integer id = companyDao.getcompanyId(userModel.getCompanyName());
		if(id == null){
			companyDao.addCompany(userModel);
		}else{
			userModel.setCompanyId(id);
		}
		contractDao.addContract(userModel);
	}

	/**
	 * 修改签约
	 * 
	 * @param userModel
	 * @return
	 */
	public void updateContract(ContractInfo userModel) {
		userModel.setUpdateTime(getAllTime());
		contractDao.updateContract(userModel);
	}
	
	
}
