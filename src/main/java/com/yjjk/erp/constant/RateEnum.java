package com.yjjk.erp.constant;

/**
 * @program: YjjkErp
 * @description: 备案进度
 * @author: CentreS
 * @create: 2019-11-25 20:56:45
 **/
public enum RateEnum {
    RATE_TYPE_SUCCESS(0, "备案成功"),
    RATE_TYPE_COMMIT(1, "方案提交"),
    RATE_TYPE_DESIGN(2, "勘察设计"),
    RATE_TYPE_SURE(3, "方案确定"),
    RATE_TYPE_EXAMINE(4, "院方审批"),
    RATE_TYPE_SIGN(5, "合同签订"),
    RATE_TYPE_PAYMENT(6, "付款成功"),
    ;

    private Integer rateType;

    private String typeName;

    RateEnum(Integer rateType, String typeName) {
        this.rateType = rateType;
        this.typeName = typeName;
    }

    public Integer getRateType() {
        return this.rateType;
    }

    public static String getTypeName(Integer rateType) {
        for (RateEnum r : RateEnum.values()) {
            if (rateType.equals(r.getRateType())) {
                return r.typeName;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "RateEnum{" +
                "rateType=" + rateType +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
