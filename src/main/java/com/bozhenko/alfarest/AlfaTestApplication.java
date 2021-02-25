package com.bozhenko.alfarest;

import com.bozhenko.alfarest.config.ExternalServicesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@Import(ExternalServicesConfiguration.class)
@EnableCaching
public class AlfaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaTestApplication.class, args);
    }

    @Bean(name = "dateKeyGenerator")
    public KeyGenerator getDateKeyGenerator() {
        return (target, method, params) -> new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
