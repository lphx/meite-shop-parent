package cn.phlos.member.feign;

import cn.phlos.member.service.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-mayikt-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {

}
