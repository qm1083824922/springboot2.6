package com.imooc.springboot;

import com.imooc.springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }



    @Test
    public void testSort(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"张三",new BigDecimal("88"), LocalDateTime.of(2022,4,7,18,4,1,11)));
        personList.add(new Person(2,"李四",new BigDecimal("188"), LocalDateTime.of(2022,4,6,18,4,1,11)));
        personList.add(new Person(3,"王五",new BigDecimal("288"), LocalDateTime.of(2022,4,5,18,4,1,11)));
        personList.add(new Person(4,"赵六",new BigDecimal("488"), LocalDateTime.of(2022,4,4,18,4,1,11)));
        personList.add(new Person(5,"田七",new BigDecimal("88"), LocalDateTime.of(2022,4,3,18,4,1,11)));
        personList.add(new Person(6,"王大锤",new BigDecimal("88"), LocalDateTime.of(2022,4,2,18,4,1,11)));
        personList.add(new Person(7,"王二麻子",new BigDecimal("588"), LocalDateTime.of(2022,4,1,18,4,1,11)));

        //personList.sort(comparing(Person::getSalary));

        personList.forEach(System.out::println);
    }

}
