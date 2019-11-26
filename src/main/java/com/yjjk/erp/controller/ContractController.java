package com.yjjk.erp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.Info.ContractInfo;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.utility.ResultUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @program: YjjkErp
 * @description: 签约管理模块
 * @author: CentreS
 * @create: 2019-11-25 19:22:49
 **/
@RestController
public class ContractController extends BaseController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(FranchiserController.class);
	
	/**
	 * 获取签约列表
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("获取签约列表")
	@RequestMapping(value = "/ContractList", method = RequestMethod.GET)
	public CommonResult ContractList(@Valid CurrencyModel userModel) {
		try {
			List<ContractInfo> contractList = contractService.contractList(userModel);

			return ResultUtil.returnSuccess(contractList);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 新增签约
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("新增签约")
	@RequestMapping(value = "/addManager", method = RequestMethod.POST)
	public CommonResult addContract(@Valid ContractInfo userModel) {
		try {
			 contractService.addContract(userModel);
			return ResultUtil.returnSuccess("");

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 修改签约
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("修改签约")
	@RequestMapping(value = "/updateManager", method = RequestMethod.POST)
	public CommonResult updateContract(@Valid ContractInfo userModel) {
		try {
			 contractService.updateContract(userModel);
			return ResultUtil.returnSuccess("");

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
}
