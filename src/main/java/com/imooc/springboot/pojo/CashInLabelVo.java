package com.imooc.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CashInLabelVo {

    private Integer sourceType;
    private BigDecimal amt;
    private Integer rechargeTimes;
}
