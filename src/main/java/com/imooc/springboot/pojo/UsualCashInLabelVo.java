package com.imooc.springboot.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsualCashInLabelVo {
    //支付宝
    private List<CashInLabelChannelVo> aliPay = new ArrayList<>();
    //微信支付
    private List<CashInLabelChannelVo> wechatPay = new ArrayList<>();
    //苹果支付
    private List<CashInLabelChannelVo> applePay = new ArrayList<>();
}
