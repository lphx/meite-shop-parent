package cn.phlos.weixin.service;

import cn.phlos.AppEntity;
import cn.phlos.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Autor lipenghong
 * @Date 22:26 2019/12/29
 **/
@Api(tags = "微信服务接口")
public interface WeiXinService {

    @ApiOperation(value = "微信服务调用接口")
    @GetMapping("/getApp")
    public BaseResponse<AppEntity> getApp();

}
