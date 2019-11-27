package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: YjjkErp
 * @description: 公司模块
 * @author: CentreS
 * @create: 2019-11-26 21:45:52
 **/
@RestController
@RequestMapping("/company")
@Api(tags = "公司模块")
public class CompanyController extends BaseController {

    @ApiOperation("获取新增医院备案公司下拉列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<ListVO>> getList(@ApiParam(value = "经销商") @RequestParam("franchiserId") Integer franchiserId) {
        try {

            List<ListVO> list = super.companyService.getList(franchiserId);
            return ResultUtil.returnSuccess(list);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
