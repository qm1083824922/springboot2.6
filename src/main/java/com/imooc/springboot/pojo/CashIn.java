package com.imooc.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("cash_in")
public class CashIn {
    private Integer customerId;
    private Integer sourceType;
    private BigDecimal amt;
}
