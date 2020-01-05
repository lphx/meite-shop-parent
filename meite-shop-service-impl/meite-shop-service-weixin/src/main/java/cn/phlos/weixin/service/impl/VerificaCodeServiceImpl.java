package cn.phlos.weixin.service.impl;

import cn.phlos.base.BaseApiService;
import cn.phlos.base.BaseResponse;
import cn.phlos.constants.Constants;
import cn.phlos.util.RedisUtil;
import cn.phlos.weixin.service.VerificaCodeService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor lipenghong
 * @Date 20:26 2020/1/5
 **/
@RestController
public class VerificaCodeServiceImpl extends BaseApiService<JSONObject> implements VerificaCodeService {
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public BaseResponse<JSONObject> verificaWeixinCode(String phone, String weixinCode) {
		if (StringUtils.isEmpty(phone)) {
			return setResultError("手机号码不能为空!");
		}
		if (StringUtils.isEmpty(weixinCode)) {
			return setResultError("注册码不能为空!");
		}
		String weiXinCode = Constants.WEIXINCODE_KEY + phone;
		String code = redisUtil.getString(weiXinCode);
		if (StringUtils.isEmpty(code)) {
			return setResultError("注册码已经过期,请重新发送验证码");
		}
		if (!code.equals(weixinCode)) {
			return setResultError("注册码不正确");
		}

		//移除redis
		redisUtil.delKey(weiXinCode);
		return setResultSuccess("注册码验证码正确");
	}

}
