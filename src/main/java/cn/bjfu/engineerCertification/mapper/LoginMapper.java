package cn.bjfu.engineerCertification.mapper;

import cn.bjfu.engineerCertification.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jxy on 2021/4/19 0019 17:09
 */
@Mapper
public interface LoginMapper {
    @Select("select * from User where username = #{username} and password = #{password} ")
    public UserInfo get(UserInfo userInfo);
}
