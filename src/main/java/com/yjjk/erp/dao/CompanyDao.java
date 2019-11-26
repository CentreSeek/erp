package com.yjjk.erp.dao;

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

}
