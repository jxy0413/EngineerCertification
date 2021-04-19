package cn.bjfu.engineerCertification.config;

import cn.bjfu.engineerCertification.interceptor.LogInterceptor;
import cn.bjfu.engineerCertification.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jxy on 2021/4/19 0019 16:59
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;

    @Autowired
    TokenInterceptor tokenInterceptor;

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册log拦截器
        registry
                .addInterceptor(logInterceptor)
                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/swagger-ui/*")
                .excludePathPatterns("/v3/*")
                .excludePathPatterns("/webjars/**");

        // 注册其他拦截器
        registry
                .addInterceptor(tokenInterceptor)
                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/swagger-ui/*")
                .excludePathPatterns("/v3/*")
                .excludePathPatterns("/webjars/**");
    }
}