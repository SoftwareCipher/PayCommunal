package com.pay.paycommunal.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pattern {
    private Long id;
    private String namePattern;
    private int Iban;
    private String goal;
    private Long phone;
}
