package gl.linpeng.ai.qingyan;

import gl.linpeng.ai.commons.TokenUtil;
import gl.linpeng.ai.qingyan.config.QingyanProperties;
import gl.linpeng.ai.qingyan.constant.Constant;
import gl.linpeng.ai.qingyan.protocol.request.QingyanChatGlmTurboRequest;
import gl.linpeng.ai.qingyan.protocol.request.QingyanRequest;
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
            invokeChatGlmTurboSSE(requestTurbo);
        } else {
            throw new RuntimeException("Not support request type");
        }

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
        return TokenUtil.getJwtToken(headers, payload, Constant.TOKEN_KEY);
    }
}
