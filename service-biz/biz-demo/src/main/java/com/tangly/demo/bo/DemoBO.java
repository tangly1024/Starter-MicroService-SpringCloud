package com.tangly.demo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoBO {
    private Long id;
    private String query;
    private String result;
}
