package com.imooc.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.imooc.springboot.mapper.CashInMapper;
import com.imooc.springboot.mapper.UserMapper;
import com.imooc.springboot.pojo.CashIn;
import com.imooc.springboot.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    private CashInMapper cashInMapper;

    @GetMapping("/testSelect")
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @GetMapping("/getCashInList/{customerId}")
    public List<CashIn> getCashInList(@PathVariable Integer customerId){
        LambdaQueryWrapper<CashIn> cashInLambdaQueryWrapper = new LambdaQueryWrapper<>();
        cashInLambdaQueryWrapper.eq(CashIn::getCustomerId,customerId);
        return cashInMapper.selectList(cashInLambdaQueryWrapper);
    }

}
