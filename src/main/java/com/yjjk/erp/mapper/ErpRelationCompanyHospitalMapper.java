package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRelationCompanyHospital;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.Map;

public interface ErpRelationCompanyHospitalMapper extends MyMapper<ErpRelationCompanyHospital> {

    /**
     * 获取companyId
     * @param hospitalId
     * @return
     */
    Integer getCompanyId(Integer hospitalId);
    int getCount(Map<String,Object> paraMap);
}