package cn.phlos.weixin.service.impl;

import cn.phlos.AppEntity;
import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor lipenghong
 * @Date 22:33 2019/12/29
 **/
@RestController
public class WeiXinServiceImpl extends BaseApiService<AppEntity> implements WeiXinService {
    @Override
    public BaseResponse<AppEntity> getApp() {
        return setResultSuccess(new AppEntity("aaa","aaaa"));
    }
}
