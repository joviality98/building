package com.building;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"com.building"})
@MapperScan(basePackages = {"com.building.dao"})
public class BuildingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingApplication.class, args);
    }

}
