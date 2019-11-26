package com.yjjk.erp.controller;

import com.yjjk.erp.configer.CommonResult;
import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.entity.Info.CurrencyModel;
import com.yjjk.erp.entity.Info.ManangerUserModel;
import com.yjjk.erp.utility.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: YjjkErp
 * @description: 管理员模块
 * @author: CentreS
 * @create: 2019-11-25 19:18:16
 **/
@RestController
public class ManagerController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);

	/**
	 * 获取管理员列表
	 *
	 * @param userModel
	 * @return
	 */
	@ApiOperation("获取管理员列表")
	@RequestMapping(value = "/ManagerList", method = RequestMethod.GET)
	public CommonResult ManagerList(@Valid CurrencyModel userModel) {
		try {
			List<ManangerUserModel> userList = managerService.managerList(userModel);

			return ResultUtil.returnSuccess(userList);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 获取角色列表
	 *
	 * @return
	 */
	@ApiOperation("获取角色列表")
	@RequestMapping(value = "/RoleList", method = RequestMethod.GET)
	public CommonResult RoleList() {
		try {
			List<ManangerUserModel> userList = managerService.RoleList();

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
			 managerService.addManager(userModel);

			return ResultUtil.returnSuccess("");

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 删除管理员
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation("删除管理员")
	@RequestMapping(value = "/deleteManager", method = RequestMethod.GET)
	public CommonResult deleteManager(@RequestParam(value = "id") Integer id) {
		try {
			 managerService.deleteManager(id);

			return ResultUtil.returnSuccess("");

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
			managerService.updateManager(userModel);

			return ResultUtil.returnSuccess("");

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 管理员修改密码
	 *
	 * @param userModel
	 * @return
	 */
	@ApiOperation("管理员修改密码")
	@RequestMapping(value = "/ChangeManagerPassWord", method = RequestMethod.POST)
	public CommonResult ChangeManagerPassWord(@Valid ManangerUserModel userModel) {
		try {
			return managerService.ChangeManagerPassWord(userModel);



		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 管理员登录
	 *
	 * @param userModel
	 * @return
	 */
	@ApiOperation("管理员登录")
	@RequestMapping(value = "/loginManager", method = RequestMethod.POST)
	public CommonResult loginManager(@Valid ManangerUserModel userModel) {
		try {
			return managerService.loginManager(userModel);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}

	/**
	 * 管理员退出
	 *
	 * @param userModel
	 * @return
	 */
//	@ApiOperation(" 管理员退出")
//	@RequestMapping(value = "/outManager", method = RequestMethod.GET)
//	public CommonResult outManager(@Valid ManangerUserModel userModel) {
//		try {
//			return managerService.outManager(userModel);
//
//			 ResultUtil.returnSuccess("");
//
//		} catch (Exception e) {
//			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
//			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
//
//		}
//	}

	/**
	 * 确认账号是否存在
	 *
	 * @param account
	 * @return
	 */
	@ApiOperation("确认账号是否存在")
	@RequestMapping(value = "/checkAccount", method = RequestMethod.GET)
	public CommonResult checkAccount(@RequestParam(value = "account") String account) {
		try {
			return managerService.checkAccount(account);

		} catch (Exception e) {
			LOGGER.error("业务异常信息：[{}]", e.getMessage(), e);
			return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);

		}
	}


}
