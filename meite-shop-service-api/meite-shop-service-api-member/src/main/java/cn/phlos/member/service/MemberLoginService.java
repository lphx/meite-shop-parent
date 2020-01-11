package cn.phlos.member.service;

import cn.phlos.base.BaseResponse;
import cn.phlos.member.input.dto.UserLoginInpDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * 
 * @description:用户登陆接口服务
 */
@Api(tags = "用户登陆服务接口")
public interface MemberLoginService {
	/**
	 * 用户登陆接口
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/login")
	@ApiOperation(value = "会员用户登陆信息接口")
	BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO);

}
