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
public class MyHospitalsVO {
    @ApiModelProperty("医院id")
    private Integer id;
    @ApiModelProperty("医院名称")
    private String name;
    @ApiModelProperty("状态 0：备案申请中 1：备案成功 2：备案失败 3：备案过期 4：已合作 5：已终止")
    private Integer rateType;
    @ApiModelProperty("状态名")
    private String rateName;
    @ApiModelProperty("申请时间")
    private String createTime;
    @ApiModelProperty("参数时间")
    private String objectTime;

}
