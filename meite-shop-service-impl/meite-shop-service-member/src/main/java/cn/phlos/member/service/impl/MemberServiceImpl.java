package cn.phlos.member.service.impl;

import cn.phlos.AppEntity;
import cn.phlos.member.feign.WeinXinServiceFeign;
import cn.phlos.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员服务实现接口
 * @Autor lipenghong
 * @Date 19:50 2019/12/30
 **/
@RestController
public class MemberServiceImpl implements MemberService {

    @Autowired
    private WeinXinServiceFeign weinXinServiceFeign;

    @Override
    public AppEntity memberToWeiXin() {
        return weinXinServiceFeign.getApp();
    }
}
