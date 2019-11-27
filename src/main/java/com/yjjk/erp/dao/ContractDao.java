package com.yjjk.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;

@Component
public interface ContractDao {

	/**
	 * 获取签约列表
	 * 
	 * @param userModel
	 * @return
	 */
	List<ContractInfo> contractList(@Param(value = "userModel")CurrencyModel userModel);
	
	/**
	 * 新增签约
	 * 
	 * @param userModel
	 * @return
	 */
	void addContract(@Param(value = "userModel")ContractInfo userModel);
	
	/**
	 * 修改签约
	 * 
	 * @param userModel
	 * @return
	 */
	void updateContract(@Param(value = "userModel")ContractInfo userModel);

	/**
	 * 获取签约总数
	 * 
	 * @return
	 */
	Integer getcontractNum();



}
