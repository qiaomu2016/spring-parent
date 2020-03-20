package com.yaomy.control.test;


import com.yaomy.sgrain.aop.config.InterceptorAutoConfiguration;
import com.yaomy.sgrain.network.config.HttpClientAutoConfiguration;
import com.yaomy.sgrain.redis.config.RedisAutoConfiguration;
import com.yaomy.sgrain.returnvalue.config.ReturnValueAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.yaomy.control","com.yaomy.sgrain"}, exclude = {ReturnValueAutoConfiguration.class, InterceptorAutoConfiguration.class, HttpClientAutoConfiguration.class})
public class HandlerBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(HandlerBootStrap.class, args);
    }

}
