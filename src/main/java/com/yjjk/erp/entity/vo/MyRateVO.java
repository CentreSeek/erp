package com.yjjk.erp.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: YjjkErp
 * @description: 医院管理：医院信息
 * @author: CentreS
 * @create: 2019-11-25 20:23:08
 **/
@Data
@Accessors(chain = true)
@ApiModel("医院信息")
public class MyRateVO {
    @ApiModelProperty("医院id")
    private Integer id;
    @ApiModelProperty("医院名称")
    private String name;
    @ApiModelProperty("科室")
    private String departmentName;
    @ApiModelProperty("状态")
    private Integer rateType;
    @ApiModelProperty("状态名")
    private String rateName;
    @ApiModelProperty("备案期限")
    private String recordValidityDate;

}
