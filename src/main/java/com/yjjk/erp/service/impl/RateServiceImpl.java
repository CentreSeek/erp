package com.yjjk.erp.service.impl;

import com.yjjk.erp.constant.RateEnum;
import com.yjjk.erp.entity.bo.AddRateBO;
import com.yjjk.erp.entity.pojo.ErpRateInfo;
import com.yjjk.erp.entity.vo.MyRateVO;
import com.yjjk.erp.entity.vo.RatesInfoVO;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.RateService;
import com.yjjk.erp.utility.ReflectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    @Override
    public int addRate(AddRateBO addRateBO) {
        if (addRateBO.getRateType() == null) {
            addRateBO.setRateType(0);
        }
        ErpRateInfo erpRateInfo = ReflectUtils.transformToBean(addRateBO, ErpRateInfo.class);
        int i = super.erpRateInfoMapper.insertSelective(erpRateInfo);
        int id = super.erpRateInfoMapper.selectId(erpRateInfo);
        if (i == 0) {
            throw new RuntimeException("插入进度异常");
        }
        erpRateInfo.setId(id);
        erpRateInfo.setUpdateTime(new Date());
        int j = super.erpRecordInfoMapper.updateRateId(erpRateInfo);
        if (i == 0) {
            throw new RuntimeException("更新进度异常");
        }
        return id;
    }

    @Override
    public List<MyRateVO> getMyRate(Integer companyId) {
        List<MyRateVO> myRate = super.erpRateInfoMapper.getMyRate(companyId);
        for (MyRateVO myRateVO : myRate) {
            myRateVO.setRateName(RateEnum.getTypeName(myRateVO.getRateType()));
        }
        return myRate;
    }
}
