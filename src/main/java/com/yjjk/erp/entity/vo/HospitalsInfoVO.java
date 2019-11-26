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
public class HospitalsInfoVO {
    @ApiModelProperty("医院id")
    private Integer id;
    @ApiModelProperty("医院名称")
    private String name;
    @ApiModelProperty("地区")
    private String place;
    @ApiModelProperty("区县")
    private String area;
    @ApiModelProperty("状态 0：未备案 1：已备案 2：已合作 3：已失效")
    private Integer rateType;
    @ApiModelProperty("维护人信息")
    private String userInfo;
    @ApiModelProperty("最新备案信息")
    private String rateInfo;
    @ApiModelProperty("备案有效期")
    private String recordValidityDate;

    private Integer rateTypeRate;
    private String createTimeRate;

}
