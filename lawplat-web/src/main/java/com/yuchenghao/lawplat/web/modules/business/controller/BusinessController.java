package com.yuchenghao.lawplat.web.modules.business.controller;


import cn.hutool.core.util.NumberUtil;
import com.yuchenghao.lawplat.common.api.Result;
import com.yuchenghao.lawplat.common.enums.EBusiness;
import com.yuchenghao.lawplat.common.enums.EResult;
import com.yuchenghao.lawplat.service.business.BusinessService;
import com.yuchenghao.lawplat.web.modules.BaseController;
import com.yuchenghao.lawplat.common.vo.business.BusinessVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController<Business> extends BaseController<Business> {

    @Resource
    public BusinessService businessService;

    @GetMapping("/business/{businessNo}")
    public Result<?> queryBusiness(@PathVariable String businessNo) {
        if(!NumberUtil.isNumber(businessNo)) return error(EResult.VALIDATE_FAILED);
        EBusiness b =  EBusiness.getBusiness(Integer.parseInt(businessNo));
        BusinessVo vo = null;
        if (b != null) {
            switch (b) {
                case CONSULT -> {
                    vo = businessService.queryBusinessConsult();
                }
                case ALLOGRAPH -> {
                    vo = businessService.queryBusinessAllograph();
                }
                case LAWSUIT -> {
                    vo = businessService.queryBusinessLawsuit();
                }
                case ALTERNATIVE_DISPUTE_RESOLUTION -> {
                    vo = businessService.queryBusinessADR();
                }
            }
            return success(vo);
        }
        return error(EResult.FAILED);
    }

}


