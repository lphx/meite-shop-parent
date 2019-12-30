package cn.phlos.member.feign;

import cn.phlos.weixin.service.WeiXinService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 微信接口Feign
 * @Autor lipenghong
 * @Date 19:53 2019/12/30
 **/
@FeignClient("app-mayikt-weixin")
public interface WeinXinServiceFeign extends WeiXinService {

}
