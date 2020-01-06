package cn.phlos.weixin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Autor lipenghong
 * @Date 19:29 2019/12/30
 **/
@SpringBootApplication(scanBasePackages = "cn.phlos")
@EnableEurekaClient
@EnableSwagger2Doc
@EnableApolloConfig
@EnableFeignClients
public class AppWeiXin {
    public static void main(String[] args) {
        SpringApplication.run(AppWeiXin.class,args);
    }
}
