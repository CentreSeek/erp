package com.yjjk.erp.service.impl;

import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.service.BaseService;
import com.yjjk.erp.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: YjjkErp
 * @description: 公司模块
 * @author: CentreS
 * @create: 2019-11-26 11:57:11
 **/
@Service
public class CompanyServiceImpl extends BaseService implements CompanyService {
    @Override
    public List<ListVO> getList(Integer franchiserId) {
        return super.erpCompanyInfoMapper.getList(franchiserId);
    }

    @Override
    public int getRelation(Integer companyId, Integer hospitalId) {
        Map<String,Object> map = new HashMap<>();
        map.put("companyId",companyId);
        map.put("hospitalId",hospitalId);
        return super.erpRelationCompanyHospitalMapper.getCount(map);
    }
}
