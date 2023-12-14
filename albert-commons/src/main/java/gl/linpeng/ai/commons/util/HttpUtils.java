package gl.linpeng.ai.commons.util;

/**
 * Http util
 */
public class HttpUtils {

    private static final int HTTP_TIMEOUT = 30000;

    public static String post(String url) {
        return post(url, null);
    }

    public static String post(String url, String body) {
        String responseString = cn.hutool.http.HttpUtil.post(url, body, HTTP_TIMEOUT);
        System.out.println("原始响应:" + responseString);
        return responseString;
    }

    public static String post(String url, String body, String jwtToken) {
        return cn.hutool.http.HttpUtil.createPost(url)
                .body(body)
                .timeout(HTTP_TIMEOUT)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken)
                .execute()
                .body();
    }
}
