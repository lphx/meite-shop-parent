package cn.phlos.member.service.impl;

import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.constants.Constants;
import cn.phlos.entity.UserEntity;
import cn.phlos.member.feign.VerificaCodeServiceFeign;
import cn.phlos.member.mapper.UserMapper;
import cn.phlos.member.service.MemberRegisterService;
import cn.phlos.util.MD5Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private VerificaCodeServiceFeign verificaCodeServiceFeign;

	@Override
	public BaseResponse<JSONObject> register(@RequestBody UserEntity userEntity, String registCode) {
		// 1.验证参数
		String userName = userEntity.getUserName();
		if (StringUtils.isEmpty(userName)) {
			return setResultError("用户名称不能为空!");
		}
		String mobile = userEntity.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		String password = userEntity.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		String newPassWord = MD5Util.MD5(password);
		// 将密码采用MD5加密
		userEntity.setPassword(newPassWord);
		// 调用微信接口,验证注册码是否正确
		BaseResponse<JSONObject> resultVerificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile,
				registCode);
		if (!resultVerificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)) {
			return setResultError(resultVerificaWeixinCode.getMsg());
		}
		int registerResult = userMapper.register(userEntity);
		return registerResult > 0 ? setResultSuccess("注册成功") : setResultSuccess("注册失败");

	}

}

