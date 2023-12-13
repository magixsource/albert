package gl.linpeng.ai.commons;

/**
 * Http util
 */
public class HttpUtil {

    private static final int HTTP_TIMEOUT = 5000;

    public static String post(String url) {
        return post(url, null);
    }

    public static String post(String url, String body) {
        String responseString = cn.hutool.http.HttpUtil.post(url, body, HTTP_TIMEOUT);
        System.out.println("原始响应:" + responseString);
        return responseString;
    }
}
