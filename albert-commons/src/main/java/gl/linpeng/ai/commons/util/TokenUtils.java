package gl.linpeng.ai.commons.util;


import cn.hutool.jwt.JWTUtil;

import java.util.Map;

public class TokenUtils {

    /**
     * Get jwt token
     *
     * @param headers header
     * @param payload payload
     * @param key     key
     * @return token
     */
    public static String getJwtToken(Map<String, Object> headers, Map<String, Object> payload, String key) {
        String token = null;
        try {
            token = JWTUtil.createToken(headers, payload, key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
