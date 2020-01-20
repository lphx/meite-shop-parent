package cn.phlos.member.feign;

import cn.phlos.member.service.QQAuthoriService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-mayikt-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
