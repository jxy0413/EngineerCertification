package cn.bjfu.engineerCertification.controller;

import cn.bjfu.engineerCertification.annotation.TokenAuth;
import cn.bjfu.engineerCertification.entity.UserInfo;
import cn.bjfu.engineerCertification.model.RetResult;
import cn.bjfu.engineerCertification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jxy on 2021/4/19 0019 18:31
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserService userInfoService;

    @TokenAuth()
    @GetMapping("/{id}")
    public RetResult getUser(@PathVariable Integer id) {
        UserInfo userInfo = userInfoService.getUserInfo(id);
        if (null == userInfo) {
            return RetResult.NO_DATA();
        } else {
            return RetResult.SUCCESS(userInfo);
        }
    }
}
