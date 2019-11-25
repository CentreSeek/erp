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
import com.yjjk.erp.entity.Info.FranchiserUserModel;
import com.yjjk.erp.entity.Info.ManangerUserModel;
import com.yjjk.erp.utility.ResultUtil;

import io.swagger.annotations.ApiOperation;
/**
 * @program: YjjkErp
 * @description: 管理员模块
 * @author: CentreS
 * @create: 2019-11-25 19:18:16
 **/
@RestController
@RequestMapping("/Manager")
public class ManagerController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);
	
	/**
	 * 获取管理员列表
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("获取管理员列表")
	@RequestMapping(value = "/ManagerList", method = RequestMethod.POST)
	public CommonResult ManagerList(@Valid ManangerUserModel userModel) {
		try {
			List<ManangerUserModel> userList = managerService.ManagerList(userModel);

			return ResultUtil.returnSuccess(userList);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 新增管理员
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("新增管理员")
	@RequestMapping(value = "/addManager", method = RequestMethod.POST)
	public CommonResult addManager(@Valid ManangerUserModel userModel) {
		try {
			String phone = managerService.addManager(userModel);

			return ResultUtil.returnSuccess(phone);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 删除管理员
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("删除管理员")
	@RequestMapping(value = "/deleteManager", method = RequestMethod.POST)
	public CommonResult deleteManager(@Valid ManangerUserModel userModel) {
		try {
			String phone = managerService.deleteManager(userModel);

			return ResultUtil.returnSuccess(phone);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
	/**
	 * 编辑管理员
	 * 
	 * @param userModel
	 * @return
	 */
	@ApiOperation("编辑管理员")
	@RequestMapping(value = "/updateManager", method = RequestMethod.POST)
	public CommonResult updateManager(@Valid ManangerUserModel userModel) {
		try {
			String phone = managerService.updateManager(userModel);

			return ResultUtil.returnSuccess(phone);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}
	
}
