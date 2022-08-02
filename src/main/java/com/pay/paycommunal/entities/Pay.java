package com.pay.paycommunal.entities;

import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;

@Getter
@Setter
public class Pay {
    private Long id;
    private Pattern pattern;
    private Long cartNumber;
    private Long sum;
    private String status;
    private Data createTime;
    private Data changeTime;
}
