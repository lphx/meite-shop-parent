package cn.phlos;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Autor lipenghong
 * @Date 19:57 2019/12/30
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@EnableApolloConfig
@MapperScan(basePackages = "cn.phlos.member.mapper")
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }
}
