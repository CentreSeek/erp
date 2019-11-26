package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRateInfo;
import com.yjjk.erp.entity.vo.RatesInfoVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpRateInfoMapper extends MyMapper<ErpRateInfo> {

    List<RatesInfoVO> getRatesInfo(Integer hospitalId);
}