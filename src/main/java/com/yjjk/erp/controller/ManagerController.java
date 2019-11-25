package com.yjjk.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
