package com.yjjk.erp.mapper;


import com.yjjk.erp.entity.pojo.ErpRateInfo;
import com.yjjk.erp.entity.vo.MyRateVO;
import com.yjjk.erp.entity.vo.RatesInfoVO;
import com.yjjk.erp.my.mapper.MyMapper;

import java.util.List;

public interface ErpRateInfoMapper extends MyMapper<ErpRateInfo> {

    List<RatesInfoVO> getRatesInfo(Integer hospitalId);

    /**
     * 获取进度id
     * @param erpRateInfo
     * @return
     */
    int selectId(ErpRateInfo erpRateInfo);

    /**
     * 公司名下医院进度详情
     * @param companyId
     * @return
     */
    List<MyRateVO> getMyRate(Integer companyId);
}