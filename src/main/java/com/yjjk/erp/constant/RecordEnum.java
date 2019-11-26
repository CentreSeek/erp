package com.yjjk.erp.constant;

/**
 * @program: YjjkErp
 * @description: 备案状态
 * @author: CentreS
 * @create: 2019-11-25 20:56:45
 **/
public enum RecordEnum {
    CHECK_STATUS_WAIT(0, "待审核"),
    CHECK_STATUS_PASS(1, "通过"),
    CHECK_STATUS_NO_PASS(2, "不通过"),
    CHECK_STATUS_PAST(3, "备案过期"),
    ;

    private Integer statusType;

    private String statusName;

    RecordEnum(Integer rateType, String typeName) {
        this.statusType = rateType;
        this.statusName = typeName;
    }

    public Integer getRateType() {
        return this.statusType;
    }

    public static String getTypeName(Integer rateType) {
        for (RecordEnum r : RecordEnum.values()) {
            if (rateType.equals(r.getRateType())) {
                return r.statusName;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "RecordEnum{" +
                "rateType=" + statusType +
                ", typeName='" + statusName + '\'' +
                '}';
    }
}
