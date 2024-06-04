package gl.linpeng.ai.qianwen;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;

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
                || Constants.MODEL_QWEN_MAX.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_V1.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_MAX.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_PLUS.equalsIgnoreCase(request.getModel())) {
            return invokeQianwen(request);
        } else {
            throw new RuntimeException("暂不支持该模型");
        }
    }

    private QianwenResponse invokeQianwen(QianwenRequest request) {
        String body = JSON.toJSONString(request);
        String url = Constants.HTTP_ENDPOINT_QIANWEN;
        if (Constants.MODEL_QWEN_VL_V1.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_PLUS.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_MAX.equalsIgnoreCase(request.getModel())) {
            url = Constants.HTTP_ENDPOINT_QIANWEN_VL;
        }
        String token = "Bearer " + qianwenProperties.getApiKey();
        String responseRaw = HttpUtils.post(url, body, token);
        return JSON.parseObject(responseRaw, QianwenResponse.class);
    }

}
