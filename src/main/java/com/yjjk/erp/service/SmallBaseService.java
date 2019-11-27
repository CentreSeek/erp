package com.yjjk.erp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjjk.erp.dao.CompanyDao;
import com.yjjk.erp.dao.ContractDao;
import com.yjjk.erp.dao.FranchiserDao;
import com.yjjk.erp.dao.ManagerDao;
import com.yjjk.erp.entity.wx.Configure;

public class SmallBaseService {
	
	 protected static Logger logger = LoggerFactory.getLogger(SmallBaseService.class);
	
	@Autowired
	Configure configure;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	FranchiserDao franchiserDao;
	
	@Autowired
	ContractDao contractDao;
	
	@Autowired
	CompanyDao companyDao;
	
	/**
	 * 获取当前完整时间
	 */
	public String getAllTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String sendDate = sdf.format(date);
		return sendDate;
	};
	
	/**
	 * 获取当前年月日
	 */
	public String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String sendDate = sdf.format(date);
		return sendDate;
	};
	
	/**
	 * 获取当前年月日
	 */
	public String getDateTimeTwo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String sendDate = sdf.format(date);
		return sendDate;
	};
	
	/**
	 * 获取当前时分秒
	 */
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String sendTime = sdf.format(date);
		return sendTime;
	};

}
