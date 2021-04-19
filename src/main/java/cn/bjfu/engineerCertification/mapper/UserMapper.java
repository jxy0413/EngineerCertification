package cn.bjfu.engineerCertification.mapper;

import cn.bjfu.engineerCertification.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by jxy on 2021/4/19 0019 18:33
 */
@Mapper
public interface UserMapper {
    @Select("select * from User where userId = #{userId}")
    public UserInfo get(Integer userId);
}
