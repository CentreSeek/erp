package com.yjjk.erp.service;

import com.yjjk.erp.entity.bo.HospitalsInfoBO;
import com.yjjk.erp.entity.vo.PagedGridResult;

/**
 * @program: YjjkErp
 * @description: 医院
 * @author: CentreS
 * @create: 2019-11-25 19:44:54
 **/
public interface HospitalService {

    /**
     * 获取医院信息
     * @param hospitalsInfoBO
     * @return
     */
    PagedGridResult getHospitalInfo(HospitalsInfoBO hospitalsInfoBO);

    /**
     * 同医院合作
     * @param hospitalId
     * @return
     */
    int collaborate(Integer hospitalId);

}
