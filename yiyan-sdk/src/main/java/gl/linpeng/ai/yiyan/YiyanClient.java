package gl.linpeng.ai.yiyan;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.yiyan.config.YiyanProperties;
import gl.linpeng.ai.yiyan.constant.Constant;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequest;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequestErnieBot4;
import gl.linpeng.ai.yiyan.protocol.response.YiyanResponseErnieBot4;
import gl.linpeng.ai.yiyan.protocol.response.YiyanTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 一言客户端
 */
@Component
public class YiyanClient {
    @Autowired
    private YiyanProperties yiyanProperties;

    private AccessToken accessToken;

    public void getAccessToken() {
        // 如果token为空或者已经过期
        if (accessToken == null || accessToken.isExpired()) {
            String url = Constant.HTTP_ENDPOINT_GET_TOKEN + "?grant_type=client_credentials&client_id="
                    + yiyanProperties.getApiKey() + "&client_secret=" + yiyanProperties.getApiSecret();
            String responseString = post(url);
            // 将响应转换为对象
            if (responseString != null) {
                YiyanTokenResponse response = JSON.parseObject(responseString, YiyanTokenResponse.class);
                // 正常获取到token
                accessToken = new AccessToken(response.getAccessToken(), response.getExpiresIn());
            }
        }
    }

    private String post(String url) {
        return post(url, null);
    }

    public String post(String url, String body) {
        String responseString = HttpUtil.post(url, body, Constant.HTTP_TIMEOUT);
        System.out.println("原始响应:" + responseString);
        return null;
    }

    public void invoke(YiyanRequest request) {
        getAccessToken();
        if (request instanceof YiyanRequestErnieBot4) {
            YiyanRequestErnieBot4 requestErnieBot4 = (YiyanRequestErnieBot4) request;
            invokeErnieBot4(requestErnieBot4);
        }

    }

    private void invokeErnieBot4(YiyanRequestErnieBot4 requestErnieBot4) {
        String body = JSON.toJSONString(requestErnieBot4);
        String url = Constant.HTTP_ENDPOINT_ERNIE_BOT4 + "?access_token=" + accessToken.getAccessToken();
        YiyanResponseErnieBot4 response = JSON.parseObject(post(url, body), YiyanResponseErnieBot4.class);
        System.out.println(JSON.toJSONString(response));
    }
}
