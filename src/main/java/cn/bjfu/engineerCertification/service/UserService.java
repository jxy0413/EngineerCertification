package cn.bjfu.engineerCertification.service;

import cn.bjfu.engineerCertification.entity.UserInfo;
import cn.bjfu.engineerCertification.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jxy on 2021/4/19 0019 18:32
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo getUserInfo(Integer id) {
        UserInfo userInfo = userMapper.get(id);
        return userInfo;
    }
}
