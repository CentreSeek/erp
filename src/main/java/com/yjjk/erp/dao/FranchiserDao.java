package com.yjjk.erp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface FranchiserDao {
	/**
	 * 经销商账户绑定公司
	 * 
	 * @return
	 */
	void addRelation(@Param(value = "comId") Integer companyId,@Param(value = "franId") Integer franchiserId);

}
