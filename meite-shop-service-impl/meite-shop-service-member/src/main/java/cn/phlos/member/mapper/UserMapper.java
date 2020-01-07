package cn.phlos.member.mapper;


import cn.phlos.member.mapper.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO `meite_user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, '1', null, null, null);")
	int register(UserDo userDo);

	@Select("SELECT * FROM meite_user WHERE MOBILE=#{mobile};")
	UserDo existMobile(@Param("mobile") String mobile);
}
