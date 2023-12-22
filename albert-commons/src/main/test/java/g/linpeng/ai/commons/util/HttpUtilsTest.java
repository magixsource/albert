package g.linpeng.ai.commons.util;

import gl.linpeng.ai.commons.util.HttpUtils;
import org.junit.Assert;
import org.junit.Test;

public class HttpUtilsTest {

    @Test
    public void testGet() {
        String response = HttpUtils.get("http://www.baidu.com");
        Assert.assertNotNull(response);
    }

    @Test
    public void testPost() {
        String response = HttpUtils.post("http://www.baidu.com");
        Assert.assertNotNull(response);
    }
}
