package com.yjjk.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.FileInfo;

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

	/**
	 * 修改过期协议
	 * 
	 * @return
	 */
	void clearContract(@Param(value = "nowTime") String time);

	/**
	 * 修改过期备案
	 * 
	 * @return
	 */
	void clearRecord(@Param(value = "nowTime") String time);

	/**
	 * 获取过期备案的医院id
	 * 
	 * @return
	 */
	List<Integer> getOldRecord(@Param(value = "nowTime") String time);

	/**
	 * 修改过期备案的医院信息
	 * 
	 * @return
	 */
	void clearHostpital(@Param(value = "hospital") Integer integer);
	
	/**
	 * 获取下载文件指定名称
	 * 
	 * @param id
	 * @return
	 */
	String getFile(@Param(value = "id") Integer id);
	
	/**
	 * 获取可下载文件列表
	 * 
	 * @return
	 */
	List<FileInfo> getFiles();



}
