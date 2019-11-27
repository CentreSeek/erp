package com.yjjk.erp.entity.Info;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractInfo {
	
	/**
	 * 签约编号
	 */
	@ApiParam(value = "签约编号")
	private Integer id;
	
	/**
	 * 协议编号
	 */
	@NotNull
	@ApiParam(value = "协议编号",required = true)
	private String orderNum;
	
	/**
	 * 公司id
	 */
	@ApiParam(value = "公司id")
	private Integer companyId;
	
	/**
	 * 公司名称
	 */
	@NotNull
	@ApiParam(value = "公司名称",required = true)
	private String companyName;
	
	/**
	 * 姓名
	 */
	@NotNull
	@ApiParam(value = "姓名",required = true)
	private String userName;
	
	/**
	 * 手机号
	 */
	@NotNull
	@ApiParam(value = "手机号",required = true)
	private String phone;
	
	/**
	 * 起始时间
	 */
	@NotNull
	@ApiParam(value = "起始时间",required = true)
	private String startDate;
	
	/**
	 * 结束时间
	 */
	@NotNull
	@ApiParam(value = "结束时间",required = true)
	private String endDate;
	
	/**
	 * 合作范围
	 */
	@NotNull
	@ApiParam(value = "合作范围 0：备案 1：区域 2：省级 3：市级",required = true)
	private String cooperationScope;
	
	/**
	 * 管理员id
	 */
	@NotNull
	@ApiParam(value = "管理员id",required = true)
	private Integer managerId;
	
	/**
	 * 管理员姓名
	 */
	@ApiParam(value = "管理员姓名")
	private String managerName;
	
	/**
	 * 创建时间
	 */
	@ApiParam(value = "创建时间")
	private String createTime;
	
	/**
	 * 修改时间
	 */
	@ApiParam(value = "修改时间")
	private String updateTime;
	
	/**
	 * 协议状态 0：有效 1：已终止 2：已失效
	 */
	@NotNull
	@ApiParam(value = "协议状态 0：有效 1：已终止 2：已失效",required = true)
	private Integer contractType;

}
