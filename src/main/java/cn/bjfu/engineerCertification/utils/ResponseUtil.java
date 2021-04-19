package cn.bjfu.engineerCertification.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by jxy on 2021/4/19 0019 16:57
 */
public class ResponseUtil {

    /**
     * 用于拦截器拦截后返回对象
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    public static void writeObj(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(
                JSONObject.toJSONString(
                        obj, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }
}
