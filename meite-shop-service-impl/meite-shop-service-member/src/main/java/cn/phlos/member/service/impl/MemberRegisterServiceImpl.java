package cn.phlos.member.service.impl;

import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.constants.Constants;
import cn.phlos.member.feign.VerificaCodeServiceFeign;
import cn.phlos.member.input.dto.UserInpDTO;
import cn.phlos.member.mapper.UserMapper;
import cn.phlos.member.mapper.entity.UserDo;
import cn.phlos.member.service.MemberRegisterService;
import cn.phlos.core.util.MD5Util;
import cn.phlos.core.bean.MiteBeanUtils;
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
	public BaseResponse<JSONObject> register(@RequestBody UserInpDTO userInpDTO, String registCode) {
		// 1.验证参数
		String userName = userInpDTO.getUserName();
		if (StringUtils.isEmpty(userName)) {
			return setResultError("用户名称不能为空!");
		}
		String mobile = userInpDTO.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		String password = userInpDTO.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		String newPassWord = MD5Util.MD5(password);
		// 将密码采用MD5加密
		userInpDTO.setPassword(newPassWord);
		// 调用微信接口,验证注册码是否正确
		BaseResponse<JSONObject> resultVerificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile,
				registCode);
		if (!resultVerificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)) {
			return setResultError(resultVerificaWeixinCode.getMsg());
		}
		UserDo userDo = MiteBeanUtils.dtoToDo(userInpDTO, UserDo.class);
		return  userMapper.register(userDo) > 0 ? setResultSuccess("注册成功") : setResultSuccess("注册失败");

	}

}

