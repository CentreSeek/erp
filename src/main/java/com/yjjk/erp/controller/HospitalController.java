package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.bo.PageBO;
import com.yjjk.erp.entity.vo.AllHospitalsInfoVO;
import com.yjjk.erp.entity.vo.HospitalsInfoVO;
import com.yjjk.erp.entity.vo.ListVO;
import com.yjjk.erp.entity.vo.PagedGridResult;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public CommonResult<PagedGridResult<HospitalsInfoVO>> getHospitalInfo(@Valid PageBO pageBO) {
        try {

            PagedGridResult hospitalInfo = super.hospitalService.getHospitalInfo(pageBO);
            return ResultUtil.returnSuccess(hospitalInfo);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("查询所有医院信息list")
    @RequestMapping(value = "/allHospitalList", method = RequestMethod.GET)
    public CommonResult<List<AllHospitalsInfoVO>> getAllHospitalInfo() {
        try {
            List<AllHospitalsInfoVO> hospitalInfo = super.hospitalService.getAllHospitalInfo();
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
            if (collaborate == 0){
                return ResultUtil.returnError(ErrorCodeEnum.COLLABORATE_ERROR);
            }
            return ResultUtil.returnSuccess(collaborate);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("与医院终止合作关系")
    @RequestMapping(value = "/stopCollaborate", method = RequestMethod.PUT)
    public CommonResult<Integer> stopCollaborate(@ApiParam(value = "医院id", required = true) @RequestParam("hospitalId") Integer hospitalId) {
        try {

            int collaborate = super.hospitalService.stopCollaborate(hospitalId);
            if (collaborate == 0){
                return ResultUtil.returnError(ErrorCodeEnum.STOP_COLLABORATE_ERROR);
            }
            return ResultUtil.returnSuccess(collaborate);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }

    @ApiOperation("获取新增医院备案医院下拉列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<ListVO>> getList() {
        try {

            List<ListVO> list = super.hospitalService.getList();
            return ResultUtil.returnSuccess(list);
        } catch (Exception e) {
            logger.error("业务异常信息：[{}]", e.getMessage(), e);
        }
        return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
