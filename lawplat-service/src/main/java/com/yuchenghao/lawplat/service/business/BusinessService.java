package com.yuchenghao.lawplat.service.business;

import com.yuchenghao.lawplat.common.vo.business.BusinessVo;
import com.yuchenghao.lawplat.service.BaseService;


public interface BusinessService extends BaseService {

     BusinessVo queryBusinessConsult();

     BusinessVo queryBusinessAllograph();

     BusinessVo queryBusinessLawsuit();

     BusinessVo queryBusinessADR();

}
