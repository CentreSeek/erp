package com.yjjk.erp.entity.Info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyModel {
	
	private Integer start;
	
	private Integer end;
	
	/**
	 * 当前页数
	 */
	private Integer page;
	
	/**
	 * 每页条数
	 * 
	 */
	private Integer number;

}
