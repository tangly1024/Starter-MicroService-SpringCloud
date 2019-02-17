package com.tangly.demo.service.impl;

import com.tangly.demo.bo.DemoBO;
import com.tangly.demo.enums.ResultEnum;
import com.tangly.demo.exception.BaseException;
import com.tangly.demo.service.IDemoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    public DemoBO getDemoByQuery(String query) {
        if (StringUtils.isEmpty(query)) {
            throw new BaseException(ResultEnum.PARAM_MISSING, "缺失query参数");
        }
        return new DemoBO(1L, query, "您查询的内容是: " + query);
    }
}
