package com.yjjk.erp.entity.Info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractInfo {
	
	/**
	 * 签约编号
	 */
	private Integer id;
	
	/**
	 * 协议编号
	 */
	private String orderNum;
	
	/**
	 * 公司id
	 */
	private Integer companyId;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 起始时间
	 */
	private String startDate;
	
	/**
	 * 结束时间
	 */
	private String endDate;
	
	/**
	 * 合作范围
	 */
	private String cooperationScope;
	
	/**
	 * 管理员id
	 */
	private Integer managerId;
	
	/**
	 * 管理员姓名
	 */
	private String managerName;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 修改时间
	 */
	private String updateTime;
	
	/**
	 * 协议状态 0：有效 1：已终止 2：已失效
	 */
	private Integer contractType;

}
