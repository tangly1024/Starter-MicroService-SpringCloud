package com.tangly.demo.service.impl;

import com.tangly.demo.service.IDemoService;
import com.tangly.demo.vo.DemoOVO;
import com.tangly.demo.vo.DemoPageIVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    public List<DemoOVO> getDemo(DemoPageIVO ivo) {
        List<DemoOVO> list = new ArrayList<>();
        DemoOVO vo = new DemoOVO();
        BeanUtils.copyProperties(ivo, vo);
        list.add(vo);
        return list;
    }
}
