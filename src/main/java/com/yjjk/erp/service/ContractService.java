package com.yjjk.erp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.FileInfo;
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.Info.ListData;
import com.yjjk.erp.utility.StringUtils;

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
	public ListData contractList(CurrencyModel userModel) {
		userModel.setStart(userModel.getPage() * userModel.getNumber());
		userModel.setEnd((userModel.getPage() + 1) * userModel.getNumber() - 1);
		List<ContractInfo> list = contractDao.contractList(userModel);
		for (ContractInfo contractInfo : list) {
			contractInfo.setStartDate(contractInfo.getStartDate() + "----" + contractInfo.getEndDate());
		}
		ListData listData = new ListData();
		listData.setData(list);
		listData.setTotal(contractDao.getcontractNum());
		return listData;
	}

	/**
	 * 新增签约
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public void addContract(ContractInfo userModel) {
		Integer id = companyDao.getcompanyId(userModel.getCompanyName());
		if (id == null) {
			companyDao.addCompany(userModel);
		} else {
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
	@Transactional
	public void updateContract(ContractInfo userModel) {
		userModel.setUpdateTime(getAllTime());
		contractDao.updateContract(userModel);

	}

	/**
	 * 定时清理过期记录
	 * 
	 * @param userModel
	 * @return
	 */
	@Transactional
	public void clearOldRecord() {
		String time = getDateTime();
		contractDao.clearContract(time);
		List<Integer> hospital = contractDao.getOldRecord(time);
		contractDao.clearRecord(time);
		for (Integer integer : hospital) {
			contractDao.clearHostpital(integer);
		}
		
		
	}
	
	/**
	 * 获取下载文件指定名称
	 * 
	 * @param id
	 * @return
	 */
	public String getFile(Integer id) {
		return contractDao.getFile(id);
	}
	
	/**
	 * 获取可下载文件列表
	 * 
	 * @return
	 */
	public List<FileInfo> getFiles() {
		return contractDao.getFiles();
	}

}
