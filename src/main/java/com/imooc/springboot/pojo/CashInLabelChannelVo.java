package com.imooc.springboot.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CashInLabelChannelVo {

    private Integer sourceType;

    private BigDecimal amt;

    private Integer rechargeTimes;

    private boolean isUsualLabel;
}
