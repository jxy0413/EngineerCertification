package cn.bjfu.engineerCertification.utils;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by jxy on 2021/4/19 0019 16:53
 */
public class JwtHelper {
    private Long EXPIRATION_TIME;
    private String SECRET;
    // "Bearer";
    private String TOKEN_PREFIX;
    // "Authorization"
    private String HEADER_STRING;

    public JwtHelper(String secret, long expire, String tokenPrefix, String headerString) {
        this.EXPIRATION_TIME = expire;
        this.SECRET = secret;
        TOKEN_PREFIX = tokenPrefix;
        HEADER_STRING = headerString;
    }

    public JSONObject generateToken(Map<String, Object> claims) {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.SECOND, EXPIRATION_TIME.intValue());
        Date d = c.getTime();
        String jwt =
                Jwts.builder()
                        .setClaims(claims)
                        .setExpiration(d)
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();
        JSONObject json = new JSONObject();
        json.put("Authorization", TOKEN_PREFIX + " " + jwt);
        json.put("token-type", TOKEN_PREFIX);
        json.put("expire-time", new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(d));
        return json;
    }

    public Map<String, Object> validateTokenAndGetClaims(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        System.out.println("token is:" + token);
        if (token == null) {
            return null;
        }
        Map<String, Object> body =
                Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
        return body;
    }
}