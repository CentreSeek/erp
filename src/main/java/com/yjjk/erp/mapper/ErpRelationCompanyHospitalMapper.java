package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRelationCompanyHospital;
import com.yjjk.erp.my.mapper.MyMapper;

public interface ErpRelationCompanyHospitalMapper extends MyMapper<ErpRelationCompanyHospital> {

    /**
     * 获取companyId
     * @param hospitalId
     * @return
     */
    Integer getCompanyId(Integer hospitalId);
}