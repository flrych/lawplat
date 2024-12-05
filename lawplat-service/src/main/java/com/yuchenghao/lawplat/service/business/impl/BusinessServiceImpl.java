package com.yuchenghao.lawplat.service.business.impl;

import com.yuchenghao.lawplat.common.vo.business.BusinessVo;
import com.yuchenghao.lawplat.service.BaseServiceImpl;
import com.yuchenghao.lawplat.service.business.BusinessService;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl extends BaseServiceImpl implements BusinessService {




    @Override
    public BusinessVo queryBusinessConsult() {
         //电话咨询 --> 180****9032




         //留言咨询 -->





        return null;
    }

    @Override
    public BusinessVo queryBusinessAllograph() {
        System.out.println("queryBusinessAllograph");
        return null;
    }

    @Override
    public BusinessVo queryBusinessLawsuit() {
        System.out.println("queryBusinessLawsuit");
        return null;
    }

    @Override
    public BusinessVo queryBusinessADR() {
        System.out.println("queryBusinessADR");
        return null;
    }


}
