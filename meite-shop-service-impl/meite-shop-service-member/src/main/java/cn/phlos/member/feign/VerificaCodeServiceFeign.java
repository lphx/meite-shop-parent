package cn.phlos.member.feign;

import cn.phlos.weixin.service.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-mayikt-weixin")
public interface VerificaCodeServiceFeign extends VerificaCodeService {

}
