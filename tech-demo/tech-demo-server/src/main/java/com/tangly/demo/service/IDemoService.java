package com.tangly.demo.service;

import com.tangly.demo.vo.DemoOVO;
import com.tangly.demo.vo.DemoPageIVO;

import java.util.List;

public interface IDemoService {

    List<DemoOVO> getDemo(DemoPageIVO ivo);

}
