package com.yjx.aiautocode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCaching
@SpringBootApplication
//        (exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.yjx.aiautocode.mapper")
public class AiAutocodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiAutocodeApplication.class, args);
    }

}
