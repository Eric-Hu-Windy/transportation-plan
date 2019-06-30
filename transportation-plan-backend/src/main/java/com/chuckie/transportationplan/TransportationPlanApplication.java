package com.chuckie.transportationplan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Chuckie
 */
@SpringBootApplication
@MapperScan("com.chuckie.transportationplan.mapper")
public class TransportationPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportationPlanApplication.class, args);
    }

}
