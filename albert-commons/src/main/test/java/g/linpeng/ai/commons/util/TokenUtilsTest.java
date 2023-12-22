package g.linpeng.ai.commons.util;

import gl.linpeng.ai.commons.util.TokenUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TokenUtilsTest {

    @Test
    public void testGetJwtToken() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");
        Map<String, Object> payload = new HashMap<>();
        payload.put("iss", "albert");
        payload.put("exp", 1600000000);
        payload.put("iat", 1500000000);
        payload.put("sub", "123456");
        payload.put("name", "albert-mock");
        payload.put("admin", true);
        payload.put("roles", "admin");
        String key = "123456";

        String token = TokenUtils.getJwtToken(headers, payload, key);
        Assert.assertNotNull(token);
    }
}
