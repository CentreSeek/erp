package com.yjjk.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjjk.erp.entity.Info.ContractInfo;

public interface CompanyDao {

	/**
	 * 查询公司id
	 * @param companyName
	 * @return
	 */
	Integer getcompanyId(@Param(value = "name") String companyName);

	/**
	 * 新增公司
	 * @param userModel
	 */
	void addCompany(@Param(value = "company") ContractInfo userModel);
	
	/**
	 * 获取与经销商无关的公司列表
	 * 
	 * @return
	 */
	List<ContractInfo> getCompanyList(@Param(value = "id") Integer id);

	

}
