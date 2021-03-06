package com.yjjk.erp.service;

import com.yjjk.erp.entity.bo.PageBO;
import com.yjjk.erp.entity.vo.AllHospitalsInfoVO;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.entity.vo.MyHospitalsVO;
import com.yjjk.erp.entity.vo.PagedGridResult;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 医院
 * @author: CentreS
 * @create: 2019-11-25 19:44:54
 **/
public interface HospitalService {

    /**
     * 获取医院信息
     * @param pageBO
     * @return
     */
    PagedGridResult getHospitalInfo(PageBO pageBO);

    /**
     * 获取所有医院信息
     * @return
     */
    List<AllHospitalsInfoVO> getAllHospitalInfo();

    /**
     * 同医院合作
     * @param hospitalId
     * @return
     */
    int collaborate(Integer hospitalId);

    /**
     * 终止合作
     * @param hospitalId
     * @return
     */
    int stopCollaborate(Integer hospitalId);

    /**
     * 获取新增医院备案下拉列表
     * @return
     */
    List<ListVO> getList();

    /**
     * 获取医院信息
     * @param companyId
     * @return
     */
    List<MyHospitalsVO> getMyHospital(Integer companyId);





}
