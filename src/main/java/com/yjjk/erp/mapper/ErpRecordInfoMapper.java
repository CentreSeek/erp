package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.vo.RecordsInfoVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpRecordInfoMapper extends MyMapper<ErpRecordInfo> {

    /**
     * 获取备案信息列表
     * @return
     */
    List<RecordsInfoVO> getRecordsInfo();


}