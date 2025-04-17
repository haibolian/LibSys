package com.haibolian.libsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haibolian.libsys.Mapper")
public class LibSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibSysApplication.class, args);
    }

}
