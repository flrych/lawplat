package com.yuchenghao.lawplat.common.enums;

public enum EBusiness {
    CONSULT(101),     //咨询

    ALLOGRAPH(102),   //代书

    LAWSUIT(103),     //诉讼

    ALTERNATIVE_DISPUTE_RESOLUTION(104);  //非诉

    private int businessNo;

    EBusiness(int businessNo) {
        this.businessNo = businessNo;
    }

    public static EBusiness getBusiness(int businessNo) {
        for (EBusiness b : EBusiness.values()) {
            if (b.businessNo == businessNo) {
                return b;
            }
        }
        return null;
    }
}
