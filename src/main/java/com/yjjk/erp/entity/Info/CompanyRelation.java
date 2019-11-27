package com.yjjk.erp.entity.Info;

import java.util.List;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRelation {
	
	/**
	 * 经销商id
	 */
	@NotNull
	@ApiParam(value = "经销商id",required = true)
	private Integer franchiserId;
	
	/**
	 * 绑定公司id列表
	 */
	@NotNull
	@ApiParam(value = "绑定公司id列表",required = true)
	private List<Integer> comList;

}
