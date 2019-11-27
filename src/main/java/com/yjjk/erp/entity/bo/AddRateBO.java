package com.yjjk.erp.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @program: YjjkErp
 * @description: 新增进度接口
 * @author: CentreS
 * @create: 2019-11-27 10:00:18
 **/
@Data
@Accessors(chain = true)
@ApiModel("新增进度")
public class AddRateBO {

//    @NotNull
//    @ApiModelProperty(required = true)
//    private Integer companyId;
    @NotNull
    @ApiModelProperty(required = true)
    private Integer hospitalId;
    @NotNull
    @ApiModelProperty(value = "科室",required = true)
    private String departmentName;
    @NotNull
    @ApiModelProperty(value = "商务代表",required = true)
    private String userName;
    @NotNull
    @ApiModelProperty(value = "联系方式",required = true)
    private String userPhone;
    @ApiModelProperty(value = "进度类型")
    private Integer rateType;
}
