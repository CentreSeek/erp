package com.yjjk.erp.entity.Info;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyModel {
	
	@ApiParam(value = "开始")
	private Integer start;
	@ApiParam(value = "结束")
	private Integer end;
	
	/**
	 * 当前页数
	 */
	@ApiParam(value = "当前页数",required = true)
	private Integer page;
	
	/**
	 * 每页条数
	 * 
	 */
	@ApiParam(value = "每页条数",required = true)
	private Integer number;

}
