package com.yjjk.erp.service.impl;

import com.yjjk.erp.entity.vo.RatesInfoVO;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.RateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 审核进度模块
 * @author: CentreS
 * @create: 2019-11-26 12:00:03
 **/
@Service
public class RateServiceImpl extends BaseService implements RateService {
    @Override
    public List<RatesInfoVO> getRateInfoList(Integer hospitalId) {
        return super.erpRateInfoMapper.getRatesInfo(hospitalId);
    }
}
