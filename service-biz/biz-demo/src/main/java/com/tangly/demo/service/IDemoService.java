package com.tangly.demo.service;

import com.tangly.demo.bo.DemoBO;
import com.tangly.demo.exception.BaseException;

/**
 * 测试接口
 */
public interface IDemoService {

    DemoBO getDemoByQuery(String query) throws BaseException;

}
