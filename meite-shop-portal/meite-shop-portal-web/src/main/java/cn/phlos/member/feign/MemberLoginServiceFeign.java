package cn.phlos.member.feign;

import cn.phlos.member.service.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("app-mayikt-member")
public interface MemberLoginServiceFeign extends MemberLoginService {

}
