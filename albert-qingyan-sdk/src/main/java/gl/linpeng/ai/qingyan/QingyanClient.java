package gl.linpeng.ai.qingyan;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.commons.util.TokenUtils;
import gl.linpeng.ai.qingyan.config.QingyanProperties;
import gl.linpeng.ai.qingyan.constant.Constants;
import gl.linpeng.ai.qingyan.protocol.request.QingyanChatGlmTurboRequest;
import gl.linpeng.ai.qingyan.protocol.request.QingyanRequest;
import gl.linpeng.ai.qingyan.protocol.response.QingyanChatGlmTurboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Qingyan client
 */
@Component
public class QingyanClient {

    @Autowired
    private QingyanProperties qingyanProperties;

    public void invoke(QingyanRequest request) {
        if (request instanceof QingyanChatGlmTurboRequest) {
            QingyanChatGlmTurboRequest requestTurbo = (QingyanChatGlmTurboRequest) request;
            // 异步调用
            // invokeChatGlmTurboAsync(requestTurbo);
            // 同步调用
            invokeChatGlmTurbo(requestTurbo);
        } else {
            throw new RuntimeException("Not support request type");
        }

    }

    private void invokeChatGlmTurbo(QingyanChatGlmTurboRequest requestTurbo) {
        // 生成JWT token
        String token = getJwtToken();
        String body = JSON.toJSONString(requestTurbo);
        String responseString = HttpUtils.post(Constants.HTTP_ENDPOINT_CHAT_GLM_TURBO_SYNC, body, token);
        QingyanChatGlmTurboResponse response = JSON.parseObject(responseString, QingyanChatGlmTurboResponse.class);
        if (Constants.HTTP_STATUS_SUCCESS == response.getCode()) {
            System.out.println("正确响应:" + JSON.toJSONString(response.getData()));
        } else if (Constants.HTTP_STATUS_ERROR == response.getCode()) {
            System.out.println("错误响应:" + JSON.toJSONString(response.getData()));
        } else {
            System.out.println("其他响应:" + JSON.toJSONString(response.getData()));
        }
    }

    /**
     * 以Async方式调用ChatGlmTurbo模型
     *
     * @param requestTurbo requestTurbo
     */
    private void invokeChatGlmTurboAsync(QingyanChatGlmTurboRequest requestTurbo) {
        // 生成JWT token
        String token = getJwtToken();

    }

    /**
     * 以SSE方式调用ChatGlmTurbo模型
     *
     * @param requestTurbo requestTurbo
     */
    private void invokeChatGlmTurboSSE(QingyanChatGlmTurboRequest requestTurbo) {
        // 生成JWT token
        String token = getJwtToken();
        // TODO SSE协议通讯
    }

    private String getJwtToken() {
        Map<String, Object> headers = new HashMap<>(2);
        // 属性表示签名使用的算法，默认为 HMAC SHA256（
        headers.put("alg", "HS256");
        // 属性表示令牌的类型，JWT 令牌统一写为 SIGN
        headers.put("sign_type", "SIGN");
        Map<String, Object> payload = new HashMap<>(3);
        payload.put("api_key", qingyanProperties.getApiKey());
        long timestamp = System.currentTimeMillis();
        payload.put("timestamp", timestamp);
        // 过期时间 = 当前时间+1小时
        payload.put("exp", timestamp + 3600 * 1000);
        return TokenUtils.getJwtToken(headers, payload, Constants.TOKEN_KEY);
    }
}
