package com.xzy.basis.config;


import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xzy
 * @date 2019/9/2 15:58
 */

@Configuration
@MapperScan(basePackages = "com.xzy.basis.modules.*.mapper")
public class MyBatisConfig {

}
