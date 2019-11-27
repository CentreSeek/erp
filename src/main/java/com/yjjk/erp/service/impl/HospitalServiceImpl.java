package com.yjjk.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.yjjk.erp.constant.RateEnum;
import com.yjjk.erp.entity.bo.HospitalsInfoBO;
import com.yjjk.erp.entity.pojo.ErpHospitalInfo;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.entity.vo.PagedGridResult;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public int collaborate(Integer hospitalId) {
        ErpHospitalInfo erpHospitalInfo = new ErpHospitalInfo();
        erpHospitalInfo.setId(hospitalId);
        erpHospitalInfo.setRateType(2);
        erpHospitalInfo.setUpdateTime(new Date());
        return super.erpHospitalInfoMapper.updateByPrimaryKeySelective(erpHospitalInfo);
    }

    @Override
    public List<ListVO> getList() {
        return super.erpHospitalInfoMapper.getList();
    }
}
