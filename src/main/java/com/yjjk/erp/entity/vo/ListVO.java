package com.yjjk.erp.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: YjjkErp
 * @description:
 * @author: CentreS
 * @create: 2019-11-25 20:23:08
 **/
@Data
@Accessors(chain = true)
@ApiModel("列表")
public class ListVO {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
}
