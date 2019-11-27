package com.yjjk.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.yjjk.erp.constant.HistoryEnum;
import com.yjjk.erp.constant.RateEnum;
import com.yjjk.erp.entity.bo.HospitalsInfoBO;
import com.yjjk.erp.entity.pojo.ErpCompanyInfo;
import com.yjjk.erp.entity.pojo.ErpHospitalInfo;
import com.yjjk.erp.entity.pojo.ErpRecordInfo;
import com.yjjk.erp.entity.vo.AllHospitalsInfoVO;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.entity.vo.MyHospitalsVO;
import com.yjjk.erp.entity.vo.PagedGridResult;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.HospitalService;
import com.yjjk.erp.utility.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: YjjkErp
 * @description: 医院
 * @author: CentreS
 * @create: 2019-11-25 20:21:20
 **/
@Service
public class HospitalServiceImpl extends BaseService implements HospitalService {

    @Override
    public PagedGridResult getHospitalInfo(HospitalsInfoBO hospitalsInfoBO) {
        PageHelper.startPage(hospitalsInfoBO.getPage(), hospitalsInfoBO.getPageSize());
        List<HospitalsInfoVO> hospitalsInfo = super.erpHospitalInfoMapper.getHospitalsInfo();
        for (HospitalsInfoVO hospitalsInfoVO : hospitalsInfo) {
            if (hospitalsInfoVO.getRateTypeRate() != null) {
                hospitalsInfoVO.setRateInfo(hospitalsInfoVO.getCreateTimeRate() + " " + RateEnum.getTypeName(hospitalsInfoVO.getRateType()));
            }
        }
        return setterPagedGrid(hospitalsInfo, hospitalsInfoBO.getPage());
    }

    @Override
    public List<AllHospitalsInfoVO> getAllHospitalInfo() {
        List<AllHospitalsInfoVO> allHospitalsInfo = super.erpHospitalInfoMapper.getAllHospitalsInfo();
        for (AllHospitalsInfoVO iter : allHospitalsInfo) {
            iter.setRateTypeName(HistoryEnum.getTypeName(iter.getRateType()));
        }
        return allHospitalsInfo;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int collaborate(Integer hospitalId) {
        ErpHospitalInfo erpHospitalInfo = new ErpHospitalInfo();
        erpHospitalInfo.setId(hospitalId);
        erpHospitalInfo.setRateType(2);
        erpHospitalInfo.setUpdateTime(new Date());
        int j = super.erpHospitalInfoMapper.updateByPrimaryKeySelective(erpHospitalInfo);

        Integer companyId = super.erpRelationCompanyHospitalMapper.getCompanyId(hospitalId);
        ErpCompanyInfo erpCompanyInfo = new ErpCompanyInfo();
        erpCompanyInfo.setCompanyId(companyId);
        erpCompanyInfo.setContractStatus(0);
        erpCompanyInfo.setUpdateTime(new Date());
        int i = super.erpCompanyInfoMapper.updateByPrimaryKeySelective(erpCompanyInfo);

        if (i == 0 || j == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }

    @Override
    public List<ListVO> getList() {
        return super.erpHospitalInfoMapper.getList();
    }

    @Override
    public List<MyHospitalsVO> getMyHospital(Integer companyId) {
        List<MyHospitalsVO> myHospitals = super.erpHospitalInfoMapper.getMyHospitals(companyId);
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("companyId", companyId);
        for (MyHospitalsVO myHospital : myHospitals) {
            paraMap.put("hospitalId", myHospital.getId());
            ErpRecordInfo recordInfo = super.erpRecordInfoMapper.getByHospitalAndCompanyId(paraMap);
            switch (myHospital.getRateType()) {
                case 0:
                    break;
                case 1:
                    switch (recordInfo.getCheckStatus()) {
                        case 0:
                            myHospital.setRateName("备案申请中").setRateType(0).setCreateTime(DateUtil.getDateTime(recordInfo.getCreateTime()));
                            break;
                        case 1:
                            myHospital.setRateName("备案成功").setRateType(1).setCreateTime(DateUtil.getDateTime(recordInfo.getCreateTime())).setObjectTime(DateUtil.getDateTime(recordInfo.getUpdateTime()));
                            break;
                        case 2:
                            myHospital.setRateName("备案失败").setRateType(2).setCreateTime(DateUtil.getDateTime(recordInfo.getCreateTime())).setObjectTime(DateUtil.getDateTime(recordInfo.getUpdateTime()));
                            break;
                        case 3:
                            myHospital.setRateName("备案过期").setRateType(3).setCreateTime(DateUtil.getDateTime(recordInfo.getCreateTime())).setObjectTime(DateUtil.getDateTime(recordInfo.getUpdateTime()));
                            break;
                        default:
                    }
                    break;
                case 2:
                    myHospital.setRateName("已合作").setRateType(4).setCreateTime(recordInfo.getCreateTime() == null ? myHospital.getCreateTime() : DateUtil.getDateTime(recordInfo.getCreateTime()));
                    break;
                case 3:
                    myHospital.setRateName("已终止").setRateType(5).setCreateTime(recordInfo.getCreateTime() == null ? myHospital.getCreateTime() : DateUtil.getDateTime(recordInfo.getCreateTime()));
                    break;
                case 4:
                    myHospital.setRateName("已过期").setRateType(3).setCreateTime(DateUtil.getDateTime(recordInfo.getCreateTime())).setObjectTime(DateUtil.getDateTime(recordInfo.getUpdateTime()));
                    break;
                default:
            }
        }
        return myHospitals;
    }

    @Transactional
    @Override
    public int stopCollaborate(Integer hospitalId) {
        ErpHospitalInfo erpHospitalInfo = new ErpHospitalInfo();
        erpHospitalInfo.setId(hospitalId);
        erpHospitalInfo.setRateType(3);
        erpHospitalInfo.setUpdateTime(new Date());
        int i = super.erpHospitalInfoMapper.updateByPrimaryKeySelective(erpHospitalInfo);

        Integer companyId = super.erpRelationCompanyHospitalMapper.getCompanyId(hospitalId);
        if (companyId == null) {
            return 0;
        }
        ErpCompanyInfo erpCompanyInfo = new ErpCompanyInfo();
        erpCompanyInfo.setCompanyId(companyId);
        erpCompanyInfo.setContractStatus(1);
        erpCompanyInfo.setUpdateTime(new Date());
        int j = super.erpCompanyInfoMapper.updateByPrimaryKeySelective(erpCompanyInfo);

        if (i == 0 || j == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }

}
