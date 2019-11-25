package com.yjjk.erp.entity.Info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractInfo {
	
	/**
	 * 协议编号
	 */
	private String order_num;
	
	/**
	 * 公司id
	 */
	private Integer company_id;
	
	/**
	 * 姓名
	 */
	private String user_name;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 起始时间
	 */
	private String start_date;
	
	/**
	 * 结束时间
	 */
	private String end_date;
	
	/**
	 * 合作范围
	 */
	private String cooperation_scope;
	
	/**
	 * 管理员id
	 */
	private Integer managerId;
	
	/**
	 * 管理员姓名
	 */
	private String managerName;
	
	/**
	 * 协议状态 0：有效 1：已终止 2：已失效
	 */
	private Integer contract_type;

}
