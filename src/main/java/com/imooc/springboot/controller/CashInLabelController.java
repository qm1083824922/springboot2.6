package com.imooc.springboot.controller;

import com.imooc.springboot.pojo.CashInLabelChannelVo;
import com.imooc.springboot.pojo.CashInLabelVo;
import com.imooc.springboot.pojo.UsualCashInLabelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cashInLabel")
public class CashInLabelController {

    @GetMapping("/getCashInUsualAmtList")
    public UsualCashInLabelVo getCashInUsualAmtList(){
        //构造用户支付数据 2, 3, 5
        List<CashInLabelVo> cashInLabelVos = Arrays.asList(
                new CashInLabelVo(2, new BigDecimal("6"),10),
                new CashInLabelVo(2, new BigDecimal("18"),5),
                new CashInLabelVo(2, new BigDecimal("20"),18),
                new CashInLabelVo(2, new BigDecimal("30"),15),
                new CashInLabelVo(3, new BigDecimal("6"),1),
                new CashInLabelVo(3, new BigDecimal("18"),1),
                new CashInLabelVo(3, new BigDecimal("30"),1),
                new CashInLabelVo(5, new BigDecimal("30"),15),
                new CashInLabelVo(5, new BigDecimal("50"),18)
        );
        List<CashInLabelChannelVo> aliPayList = new ArrayList<>();
        List<CashInLabelChannelVo> wechatPayList = new ArrayList<>();
        List<CashInLabelChannelVo> applePayList = new ArrayList<>();
        for (CashInLabelVo cashInLabelVo : cashInLabelVos) {
            if (cashInLabelVo.getSourceType()==2){
                CashInLabelChannelVo cashInLabelChannelVo = new CashInLabelChannelVo();
                BeanUtils.copyProperties(cashInLabelVo,cashInLabelChannelVo);
                aliPayList.add(cashInLabelChannelVo);
            }
            if (cashInLabelVo.getSourceType()==3){
                CashInLabelChannelVo cashInLabelChannelVo = new CashInLabelChannelVo();
                BeanUtils.copyProperties(cashInLabelVo,cashInLabelChannelVo);
                wechatPayList.add(cashInLabelChannelVo);
            }
            if (cashInLabelVo.getSourceType() == 5){
                CashInLabelChannelVo cashInLabelChannelVo = new CashInLabelChannelVo();
                BeanUtils.copyProperties(cashInLabelVo,cashInLabelChannelVo);
                applePayList.add(cashInLabelChannelVo);
            }
        }
        //排序
        List<CashInLabelChannelVo> collectAliPayList = aliPayList.stream().sorted((c1, c2) -> {
            if (!Objects.equals(c2.getRechargeTimes(), c1.getRechargeTimes())) {
                return c2.getRechargeTimes().compareTo(c1.getRechargeTimes());
            } else {
                return c2.getAmt().compareTo(c1.getAmt());
            }
        }).collect(Collectors.toList());

        List<CashInLabelChannelVo> collectWechatPayList = wechatPayList.stream().sorted((c1, c2) -> {
            if (!Objects.equals(c2.getRechargeTimes(), c1.getRechargeTimes())) {
                return c2.getRechargeTimes().compareTo(c1.getRechargeTimes());
            } else {
                return c2.getAmt().compareTo(c1.getAmt());
            }
        }).collect(Collectors.toList());

        List<CashInLabelChannelVo> collectApplePayList = applePayList.stream().sorted((c1, c2) -> {
            if (!Objects.equals(c2.getRechargeTimes(), c1.getRechargeTimes())) {
                return c2.getRechargeTimes().compareTo(c1.getRechargeTimes());
            } else {
                return c2.getAmt().compareTo(c1.getAmt());
            }
        }).collect(Collectors.toList());

        UsualCashInLabelVo usualCashInLabelVo = new UsualCashInLabelVo();
        if (collectAliPayList.size()>0){
            collectAliPayList.get(0).setUsualLabel(true);
        }
        if (collectWechatPayList.size()>0){
            collectWechatPayList.get(0).setUsualLabel(true);
        }
        if (collectApplePayList.size()>0){
            collectApplePayList.get(0).setUsualLabel(true);
        }
//        usualCashInLabelVo.setAliPay(collectAliPayList);
//        usualCashInLabelVo.setWechatPay(collectWechatPayList);
//        usualCashInLabelVo.setApplePay(collectApplePayList);
        return usualCashInLabelVo;
    }
}
