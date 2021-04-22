package cn.bjfu.engineerCertification.controller;

import cn.bjfu.engineerCertification.entity.UserInfo;
import cn.bjfu.engineerCertification.model.RetResult;
import cn.bjfu.engineerCertification.model.RetResultEnum;
import cn.bjfu.engineerCertification.service.LoginService;
import cn.bjfu.engineerCertification.utils.JwtHelper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

/**
 * Created by jxy on 2021/4/19 0019 17:01
 */
@RestController
public class LoginController {
    @Value("${jwt.SECRET}")
    private String JWT_SECRET;

    @Value("${jwt.TOKEN_PREFIX}")
    private String TOKEN_PREFIX;

    @Value("${jwt.HEADER_STRING}")
    private String HEADER_STRING;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public RetResult login(@RequestBody UserInfo userInfo){
        UserInfo login = loginService.login(userInfo);
        if (null == login) {
            return new RetResult(RetResultEnum.LOGIN_FAIL).setMsg("用户名或者密码错误或者锁定用户");
        } else {
            JSONObject token = jwtHelper.generateToken(new HashMap<>());

            stringRedisTemplate
                    .opsForValue()
                    .set(token.getString(HEADER_STRING), login.getUserId().toString());
            return RetResult.SUCCESS(token);
        }
    }

}
