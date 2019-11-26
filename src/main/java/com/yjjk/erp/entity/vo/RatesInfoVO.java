package com.yjjk.erp.entity.vo;

import com.yjjk.erp.constant.RateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: YjjkErp
 * @description: 进度记录详情
 * @author: CentreS
 * @create: 2019-11-26 09:55:48
 **/
@Data
@Accessors(chain = true)
@ApiModel("进度记录")
public class RatesInfoVO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("进度类型")
    private String rateType;
    @ApiModelProperty("具体内容")
    private String content;

    public void setRateTypeInt(Integer rateTypeInt) {
        this.rateType = RateEnum.getTypeName(rateTypeInt);
    }

    private Integer rateTypeInt;

}
