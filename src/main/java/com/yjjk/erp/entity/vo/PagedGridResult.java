package com.yjjk.erp.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("分页通用插件")
public class PagedGridResult<T> {
	
	private int page;			// 当前页数
	private int total;			// 总页数	
	private long records;		// 总记录数
	@ApiModelProperty("data")
	private List<T> rows;		// 每行显示的内容

}