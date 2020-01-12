package cn.phlos.member.service.impl;

import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.base.MeiteBeanUtils;
import cn.phlos.constants.Constants;
import cn.phlos.core.bean.MiteBeanUtils;
import cn.phlos.core.token.GenerateToken;
import cn.phlos.core.type.TypeCastHelper;
import cn.phlos.member.feign.WeinXinServiceFeign;
import cn.phlos.member.mapper.UserMapper;
import cn.phlos.member.mapper.entity.UserDo;
import cn.phlos.member.output.dto.UserOutDTO;
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
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {

    @Autowired
    private WeinXinServiceFeign weinXinServiceFeign;

    @Autowired
    private GenerateToken generateToken;
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        UserDo userDo = userMapper.existMobile(mobile);
        if (userDo == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户不存在");
        }
        // 注意需要将敏感数据进行脱敏
        // 3.将do转换成dto
        return setResultSuccess(MiteBeanUtils.doToDto(userDo, UserOutDTO.class));
    }

    @Override
    public BaseResponse<UserOutDTO> getInfo(String token) {
        // 1.验证token参数
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空!");
        }
        // 2.使用token查询redis 中的userId
        String redisUserId = generateToken.getToken(token);
        if (StringUtils.isEmpty(redisUserId)) {
            return setResultError("token已经失效或者token错误!");
        }
        // 3.使用userID查询 数据库用户信息
        Long userId = TypeCastHelper.toLong(redisUserId);
        UserDo userDo = userMapper.findByUserId(userId);
        if (userDo == null) {
            return setResultError("用户不存在!");
        }
        // 下节课将 转换代码放入在BaseApiService
        return setResultSuccess(MeiteBeanUtils.doToDto(userDo, UserOutDTO.class));
    }
    // token存放在PC端 cookie token 存放在安卓 或者IOS端 存放在本地文件中
    // 当前存在那些问题？ 用户如果退出或者修改密码、忘记密码的情况 对token状态进行标识
    // token 如何防止伪造 真正其实很难防御伪造 尽量实现在安全体系 xss 只能在一些某些业务模块上加上必须验证本人操作


}
