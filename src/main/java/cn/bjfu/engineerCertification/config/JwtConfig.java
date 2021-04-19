package cn.bjfu.engineerCertification.config;

import cn.bjfu.engineerCertification.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jxy on 2021/4/19 0019 16:50
 */
@Configuration
public class JwtConfig {
    /** 密钥 */
    @Value("${jwt.SECRET}")
    private String secret;

    /** 过期时间 */
    @Value("${jwt.EXPIRATION_TIME}")
    private long expirationTime;

    /** token前缀 */
    @Value("${jwt.TOKEN_PREFIX}")
    private String tokenPrefix;

    /** 请求头 */
    @Value("${jwt.HEADER_STRING}")
    private String headerString;

    @Value("${jwt.authorised-urls}")
    private String[] authorisedUrls;

    @Bean
    public JwtHelper jwtHelperBean() {
        return new JwtHelper(secret, expirationTime, tokenPrefix, headerString);
    }
}