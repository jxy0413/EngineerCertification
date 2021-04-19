package cn.bjfu.engineerCertification.service;

import cn.bjfu.engineerCertification.entity.UserInfo;
import cn.bjfu.engineerCertification.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jxy on 2021/4/19 0019 17:09
 */
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    /**
     * 根据用户名密码查询用户
     * @param userInfo
     * @return
     */
    public UserInfo login(UserInfo userInfo){
       UserInfo userData  =  loginMapper.get(userInfo);
       return userData;
    }
}
