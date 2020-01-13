package cn.phlos.member.feign;

import cn.phlos.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-mayikt-member")
public interface MemberServiceFeign extends MemberService {

}
