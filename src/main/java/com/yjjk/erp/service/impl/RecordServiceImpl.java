package com.yjjk.erp.service.impl;

import com.yjjk.erp.constant.RecordEnum;
import com.yjjk.erp.entity.pojo.ErpHospitalInfo;
import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.pojo.ErpRelationCompanyHospital;
import com.yjjk.erp.entity.vo.RecordsInfoVO;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.RecordService;
import com.yjjk.erp.utility.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: YjjkErp
 * @description: 审核
 * @author: CentreS
 * @create: 2019-11-26 12:00:30
 **/
@Service
public class RecordServiceImpl extends BaseService implements RecordService {
    @Override
    public List<RecordsInfoVO> getRecordsInfo() {
        return super.erpRecordInfoMapper.getRecordsInfo();
    }

    @Override
    public ErpRecordInfo getRecordInfo(Integer recordId) {
        return super.erpRecordInfoMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int checkRecord(Integer recordId, RecordEnum checkStatus) {
        ErpRecordInfo erpRecordInfo = new ErpRecordInfo();
        erpRecordInfo.setId(recordId);
        erpRecordInfo.setCheckStatus(checkStatus.getRateType());
        erpRecordInfo.setUpdateTime(new Date());
        return super.erpRecordInfoMapper.updateByPrimaryKeySelective(erpRecordInfo);
    }

    @Override
    public int postpone(ErpRecordInfo recordInfo, int calendarConstant, int times) {
        ErpRecordInfo erpRecordInfo = new ErpRecordInfo();
        erpRecordInfo.setId(recordInfo.getId());
        erpRecordInfo.setUpdateTime(new Date());
        erpRecordInfo.setEndDate(DateUtil.getPassDate(recordInfo.getEndDate(), Calendar.MONTH, times));
        return super.erpRecordInfoMapper.updateByPrimaryKeySelective(erpRecordInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addRecord(Integer hospitalId, Integer companyId) {
        ErpRecordInfo erpRecordInfo = new ErpRecordInfo();
        erpRecordInfo.setHospitalId(hospitalId);
        erpRecordInfo.setCompanyId(companyId);
        erpRecordInfo.setStartDate(DateUtil.getDate(new Date()));
        erpRecordInfo.setEndDate(DateUtil.getPassDate(DateUtil.getDate(new Date()),Calendar.MONTH,3));
        erpRecordInfo.setCheckStatus(0);
        erpRecordInfo.setStatus(0);
        int i = super.erpRecordInfoMapper.insertSelective(erpRecordInfo);

        ErpHospitalInfo erpHospitalInfo = new ErpHospitalInfo();
        erpHospitalInfo.setId(hospitalId);
        erpHospitalInfo.setUpdateTime(new Date());
        erpHospitalInfo.setRateType(1);
        int j = super.erpHospitalInfoMapper.updateByPrimaryKeySelective(erpHospitalInfo);

        ErpRelationCompanyHospital erpRelationCompanyHospital = new ErpRelationCompanyHospital();
        erpRelationCompanyHospital.setCompanyId(companyId);
        erpRelationCompanyHospital.setHospitalId(hospitalId);
        int z = super.erpRelationCompanyHospitalMapper.insertSelective(erpRelationCompanyHospital);
        if (i == 0 || j == 0 || z == 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }
}
