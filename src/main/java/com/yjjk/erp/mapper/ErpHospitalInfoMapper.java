package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpHospitalInfo;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpHospitalInfoMapper extends MyMapper<ErpHospitalInfo> {

    /**
     * 查询医院详情
     * @return
     */
    List<HospitalsInfoVO> getHospitalsInfo();
}