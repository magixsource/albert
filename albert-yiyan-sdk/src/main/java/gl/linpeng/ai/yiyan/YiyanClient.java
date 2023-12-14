package gl.linpeng.ai.yiyan;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.yiyan.config.YiyanProperties;
import gl.linpeng.ai.yiyan.constant.Constants;
import gl.linpeng.ai.yiyan.protocol.AccessToken;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequest;
import gl.linpeng.ai.yiyan.protocol.request.YiyanErnieBotRequest;
import gl.linpeng.ai.yiyan.protocol.request.YiyanErnieBot4Request;
import gl.linpeng.ai.yiyan.protocol.request.YiyanErnieBotTurboRequest;
import gl.linpeng.ai.yiyan.protocol.response.YiyanErnieBotResponse;
import gl.linpeng.ai.yiyan.protocol.response.YiyanErnieBot4Response;
import gl.linpeng.ai.yiyan.protocol.response.YiyanErnieBotTurboResponse;
import gl.linpeng.ai.yiyan.protocol.response.YiyanTokenResponse;
import org.springframework.stereotype.Component;

/**
 * 一言客户端
 */
@Component
public class YiyanClient {
    private YiyanProperties yiyanProperties;

    public YiyanClient(YiyanProperties yiyanProperties) {
        this.yiyanProperties = yiyanProperties;
    }

    private AccessToken accessToken;

    public void getAccessToken() {
        // 如果token为空或者已经过期
        if (accessToken == null || accessToken.isExpired()) {
            String url = Constants.HTTP_ENDPOINT_GET_TOKEN + "?grant_type=client_credentials&client_id="
                    + yiyanProperties.getApiKey() + "&client_secret=" + yiyanProperties.getApiSecret();
            String responseString = HttpUtils.post(url);
            // 将响应转换为对象
            if (responseString != null) {
                YiyanTokenResponse response = JSON.parseObject(responseString, YiyanTokenResponse.class);
                if (response == null || response.getAccessToken() == null) {
                    throw new RuntimeException("获取token失败");
                }
                // 正常获取到token
                accessToken = new AccessToken(response.getAccessToken(), response.getExpiresIn());
            }
        }
    }


    public void invoke(YiyanRequest request) {
        getAccessToken();
        if (request instanceof YiyanErnieBot4Request) {
            YiyanErnieBot4Request requestErnieBot4 = (YiyanErnieBot4Request) request;
            invokeErnieBot4(requestErnieBot4);
        } else if (request instanceof YiyanErnieBotRequest) {
            YiyanErnieBotRequest requestErnieBot = (YiyanErnieBotRequest) request;
            invokeErnieBot(requestErnieBot);
        } else {
            YiyanErnieBotTurboRequest requestErnieBotTurbo = (YiyanErnieBotTurboRequest) request;
            invokeErnieBotTurbo(requestErnieBotTurbo);
        }

    }

    private void invokeErnieBotTurbo(YiyanErnieBotTurboRequest requestErnieBotTurbo) {
        String body = JSON.toJSONString(requestErnieBotTurbo);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT_TURBO + "?access_token=" + accessToken.getAccessToken();
        YiyanErnieBotTurboResponse response = JSON.parseObject(HttpUtils.post(url, body), YiyanErnieBotTurboResponse.class);
        System.out.println(JSON.toJSONString(response));
    }

    private void invokeErnieBot(YiyanErnieBotRequest requestErnieBot) {
        String body = JSON.toJSONString(requestErnieBot);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT + "?access_token=" + accessToken.getAccessToken();
        YiyanErnieBotResponse response = JSON.parseObject(HttpUtils.post(url, body), YiyanErnieBotResponse.class);
        System.out.println(JSON.toJSONString(response));
    }

    private void invokeErnieBot4(YiyanErnieBot4Request requestErnieBot4) {
        String body = JSON.toJSONString(requestErnieBot4);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT4 + "?access_token=" + accessToken.getAccessToken();
        YiyanErnieBot4Response response = JSON.parseObject(HttpUtils.post(url, body), YiyanErnieBot4Response.class);
        System.out.println(JSON.toJSONString(response));
    }
}
