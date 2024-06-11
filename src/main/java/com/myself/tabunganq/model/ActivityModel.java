package com.myself.tabunganq.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ActivityModel {

    private String payment;
    private BigInteger price;
    private String activity;
}
