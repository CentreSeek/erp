package com.yjjk.erp.service;

import com.yjjk.erp.entity.vo.ListVO;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 公司
 * @author: CentreS
 * @create: 2019-11-25 19:41:43
 **/
public interface CompanyService{

    /**
     * 新增医院备案公司列表
     * @return
     */
    List<ListVO> getList(Integer franchiserId);

    int getRelation(Integer companyId, Integer hospitalId);
}
