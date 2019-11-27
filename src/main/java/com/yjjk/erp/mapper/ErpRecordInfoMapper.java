package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRateInfo;
import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.vo.RecordsInfoVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;
import java.util.Map;

public interface ErpRecordInfoMapper extends MyMapper<ErpRecordInfo> {

    /**
     * 获取备案信息列表
     *
     * @return
     */
    List<RecordsInfoVO> getRecordsInfo();

    /**
     * 更新备案进度id
     *
     * @param erpRateInfo
     * @return
     */
    int updateRateId(ErpRateInfo erpRateInfo);

    /**
     *
     * @param paraMap
     * @return
     */
    ErpRecordInfo getByHospitalAndCompanyId(Map<String, Object> paraMap);
}