package com.tangly.demo.mapper.impl;

import com.tangly.demo.bo.DemoBO;
import com.tangly.demo.mapper.DemoMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DemoMapperImpl implements DemoMapper {

    Map<Long, DemoBO> repository = new HashMap<>();

    @Override
    public void insert(DemoBO demo) {
    }

    @Override
    public void update(DemoBO demo) {

    }

    @Override
    public void delete(DemoBO demo) {

    }

    @Override
    public void selectById(Long id) {

    }
}
