package cn.phlos.member.service.impl;

import cn.phlos.AppEntity;
import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.constants.Constants;
import cn.phlos.entity.UserEntity;
import cn.phlos.member.feign.WeinXinServiceFeign;
import cn.phlos.member.mapper.UserMapper;
import cn.phlos.member.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员服务实现接口
 * @Autor lipenghong
 * @Date 19:50 2019/12/30
 **/
@RestController
public class MemberServiceImpl extends BaseApiService<UserEntity> implements MemberService {

    @Autowired
    private WeinXinServiceFeign weinXinServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserEntity> existMobile(String mobile) {
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        UserEntity userEntity = userMapper.existMobile(mobile);
        if (userEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户不存在");
        }
        // 注意需要将敏感数据进行脱敏
        userEntity.setPassword(null);
        return setResultSuccess(userEntity);
    }


}
