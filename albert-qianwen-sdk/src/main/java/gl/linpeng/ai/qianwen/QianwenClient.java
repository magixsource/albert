package gl.linpeng.ai.qianwen;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;
import org.springframework.stereotype.Component;

/**
 * 千问客户端
 */
public class QianwenClient {

    public QianwenClient(QianwenProperties qianwenProperties) {
        this.qianwenProperties = qianwenProperties;
    }

    private QianwenProperties qianwenProperties;

    public QianwenResponse invoke(QianwenRequest request) {
        if (Constants.MODEL_QWEN_TURBO.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_PLUS.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_MAX.equalsIgnoreCase(request.getModel())) {
            return invokeQianwen(request);
        } else {
            throw new RuntimeException("暂不支持该模型");
        }
    }

    private QianwenResponse invokeQianwen(QianwenRequest request) {
        String body = JSON.toJSONString(request);
        String url = Constants.HTTP_ENDPOINT_QIANWEN;
        String token = "Bearer " + qianwenProperties.getApiKey();
        QianwenResponse response = JSON.parseObject(HttpUtils.post(url, body, token), QianwenResponse.class);
        System.out.println(JSON.toJSONString(response));
        return response;
    }

}
