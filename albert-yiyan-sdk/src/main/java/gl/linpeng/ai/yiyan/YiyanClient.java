package gl.linpeng.ai.yiyan;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.yiyan.config.YiyanProperties;
import gl.linpeng.ai.yiyan.constant.Constants;
import gl.linpeng.ai.yiyan.protocol.AccessToken;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequest;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequestErnieBot;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequestErnieBot4;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequestErnieBotTurbo;
import gl.linpeng.ai.yiyan.protocol.response.YiyanResponseErnieBot;
import gl.linpeng.ai.yiyan.protocol.response.YiyanResponseErnieBot4;
import gl.linpeng.ai.yiyan.protocol.response.YiyanResponseErnieBotTurbo;
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
        if (request instanceof YiyanRequestErnieBot4) {
            YiyanRequestErnieBot4 requestErnieBot4 = (YiyanRequestErnieBot4) request;
            invokeErnieBot4(requestErnieBot4);
        } else if (request instanceof YiyanRequestErnieBot) {
            YiyanRequestErnieBot requestErnieBot = (YiyanRequestErnieBot) request;
            invokeErnieBot(requestErnieBot);
        } else {
            YiyanRequestErnieBotTurbo requestErnieBotTurbo = (YiyanRequestErnieBotTurbo) request;
            invokeErnieBotTurbo(requestErnieBotTurbo);
        }

    }

    private void invokeErnieBotTurbo(YiyanRequestErnieBotTurbo requestErnieBotTurbo) {
        String body = JSON.toJSONString(requestErnieBotTurbo);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT_TURBO + "?access_token=" + accessToken.getAccessToken();
        YiyanResponseErnieBotTurbo response = JSON.parseObject(HttpUtils.post(url, body), YiyanResponseErnieBotTurbo.class);
        System.out.println(JSON.toJSONString(response));
    }

    private void invokeErnieBot(YiyanRequestErnieBot requestErnieBot) {
        String body = JSON.toJSONString(requestErnieBot);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT + "?access_token=" + accessToken.getAccessToken();
        YiyanResponseErnieBot response = JSON.parseObject(HttpUtils.post(url, body), YiyanResponseErnieBot.class);
        System.out.println(JSON.toJSONString(response));
    }

    private void invokeErnieBot4(YiyanRequestErnieBot4 requestErnieBot4) {
        String body = JSON.toJSONString(requestErnieBot4);
        String url = Constants.HTTP_ENDPOINT_ERNIE_BOT4 + "?access_token=" + accessToken.getAccessToken();
        YiyanResponseErnieBot4 response = JSON.parseObject(HttpUtils.post(url, body), YiyanResponseErnieBot4.class);
        System.out.println(JSON.toJSONString(response));
    }
}
