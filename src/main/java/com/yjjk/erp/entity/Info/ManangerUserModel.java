package com.yjjk.erp.entity.Info;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManangerUserModel {
	
	/**
	 * 管理员id
	 */
	private Integer managerId;
	
	/**
	 * 管理员手机
	 */
	private String phone;
	
	/**
	 * 密码
	 */
	private String passWord;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 等级
	 */
	private Integer gender;
	
	/**
	 * 等级名称
	 */
	private String genderName;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 修改时间
	 */
	private String updateTime;
	
}
