package com.tangly.demo.mapper;

import com.tangly.demo.bo.DemoBO;

public interface DemoMapper {

    void insert(DemoBO demo);

    void update(DemoBO demo);

    void delete(DemoBO demo);

    void selectById(Long id);

}
