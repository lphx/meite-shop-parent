package cn.phlos.member.mapper;

import cn.phlos.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO `meite_user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, '1', null, null, null);")
	int register(UserEntity userEntity);

	@Select("SELECT * FROM meite_user WHERE MOBILE=#{mobile};")
	UserEntity existMobile(@Param("mobile") String mobile);
}
