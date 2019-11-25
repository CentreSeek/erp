package com.yjjk.erp.service;

import com.yjjk.erp.entity.bo.HospitalInfoBO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 医院
 * @author: CentreS
 * @create: 2019-11-25 19:44:54
 **/
@Service
public interface HospitalService {

    /***
     * 范德萨
     * @param
     * @Date: 20:34 2019/11/25
     * @return java.util.List<com.yjjk.erp.entity.bo.HospitalInfoBO>
     */
    List<HospitalInfoBO> getHospital();
}
