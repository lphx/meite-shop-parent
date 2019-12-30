package cn.phlos.member.service;

import cn.phlos.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 会员服务接口
 * @Autor lipenghong
 * @Date 19:47 2019/12/30
 **/
@Api(tags = "会员服务接口")
public interface MemberService {

    @ApiOperation(value = "会员服务调用微信服务")
    @GetMapping("/memberToWeiXin")
    public AppEntity memberToWeiXin();

}
