package cn.bjfu.engineerCertification.interceptor;

import cn.bjfu.engineerCertification.annotation.TokenAuth;
import cn.bjfu.engineerCertification.model.RetResult;
import cn.bjfu.engineerCertification.model.RetResultEnum;
import cn.bjfu.engineerCertification.utils.ResponseUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by jxy on 2021/4/19 0019 16:55
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Value("${jwt.SECRET}")
    private String JWT_SECRET;

    @Value("${jwt.TOKEN_PREFIX}")
    private String TOKEN_PREFIX;

    @Value("${jwt.HEADER_STRING}")
    private String HEADER_STRING;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;

        final Method method = handlerMethod.getMethod();
        // 有这个注解
        boolean methodAnn = method.isAnnotationPresent(TokenAuth.class);
        if (!methodAnn) {
            // 放行
            return super.preHandle(request, response, handler);
        }

        String token = request.getHeader(HEADER_STRING);
        if (token == null || "".equals(token)) {
            // 返回前端没有权限
            // 没有token
            ResponseUtil.writeObj(
                    response, new RetResult<>(RetResultEnum.TOKEN_FAIL).setMsg("token认证缺失"));
            return false;
        }

        Map<String, Object> body =
                Jwts.parser()
                        .setSigningKey(JWT_SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();

        // 放行
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {}

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}