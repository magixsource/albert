package gl.linpeng.ai.qianwen;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 千问客户端
 */
@Component
public class QianwenClient {

    @Autowired
    private QianwenProperties qianwenProperties;

    public void invoke(QianwenRequest request) {
        if (Constants.MODEL_QWEN_TURBO.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_PLUS.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_MAX.equalsIgnoreCase(request.getModel())) {
            invokeQianwen(request);
        } else {
            throw new RuntimeException("暂不支持该模型");
        }
    }

    private void invokeQianwen(QianwenRequest request) {
        String body = JSON.toJSONString(request);
        String url = Constants.HTTP_ENDPOINT_QIANWEN;
        String token = "Bearer " + qianwenProperties.getApiKey();
        QianwenResponse response = JSON.parseObject(HttpUtils.post(url, body, token), QianwenResponse.class);
        System.out.println(JSON.toJSONString(response));
    }

}
