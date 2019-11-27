package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpHospitalInfo;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.entity.vo.MyHospitalsVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpHospitalInfoMapper extends MyMapper<ErpHospitalInfo> {

    /**
     * 查询医院详情
     * @return
     */
    List<HospitalsInfoVO> getHospitalsInfo();

    /**
     * 获取新增医院备案下拉列表
     * @return
     */
    List<ListVO> getList();

    /**
     * 获取我的医院
     * @param companyId
     * @return
     */
    List<MyHospitalsVO> getMyHospitals(Integer companyId);
}