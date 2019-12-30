package cn.phlos.weixin.service.impl;

import cn.phlos.AppEntity;
import cn.phlos.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor lipenghong
 * @Date 22:33 2019/12/29
 **/
@RestController
public class WeiXinServiceImpl  implements WeiXinService {
    @Override
    public AppEntity getApp() {
        return new AppEntity("aaa","aaaa");
    }
}
