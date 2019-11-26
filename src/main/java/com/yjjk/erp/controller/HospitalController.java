package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.bo.HospitalsInfoBO;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.entity.vo.PagedGridResult;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: YjjkErp
 * @description: 医院管理模块
 * @author: CentreS
 * @create: 2019-11-25 19:20:27
 **/
@RestController
@RequestMapping("/hospital")
@Api(tags = "医院管理模块")
public class HospitalController extends BaseController {

    @ApiOperation("查询医院信息")
    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public CommonResult<PagedGridResult<HospitalsInfoVO>> getHospitalInfo(HospitalsInfoBO hospitalsInfoBO) {
        try {

            PagedGridResult hospitalInfo = super.hospitalService.getHospitalInfo(hospitalsInfoBO);
            return ResultUtil.returnSuccess(hospitalInfo);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("与医院确立合作关系")
    @RequestMapping(value = "/collaborate", method = RequestMethod.PUT)
    public CommonResult<Integer> collaborate(@ApiParam(value = "医院id", required = true) @RequestParam("hospitalId") Integer hospitalId) {
        try {

            int collaborate = super.hospitalService.collaborate(hospitalId);
            return ResultUtil.returnSuccess(collaborate);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
