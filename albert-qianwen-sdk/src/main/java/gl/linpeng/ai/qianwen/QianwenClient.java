package gl.linpeng.ai.qianwen;

import com.alibaba.fastjson.JSON;
import gl.linpeng.ai.commons.AlbertClient;
import gl.linpeng.ai.commons.util.HttpUtils;
import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;

/**
 * 千问客户端
 */
public class QianwenClient implements AlbertClient<QianwenResponse, QianwenRequest> {

    public QianwenClient(QianwenProperties qianwenProperties) {
        this.qianwenProperties = qianwenProperties;
    }

    private QianwenProperties qianwenProperties;

    @Override
    public QianwenResponse invoke(QianwenRequest request) {
        if (!checkModel(request)) {
            throw new RuntimeException("暂不支持该模型");
        }
        String responseRaw = invokeQianwen(request);
        return JSON.parseObject(responseRaw, QianwenResponse.class);
    }

    @Override
    public String invokeRaw(String requestJson) {
        QianwenRequest request = JSON.parseObject(requestJson, QianwenRequest.class);
        if (!checkModel(request)) {
            throw new RuntimeException("暂不支持该模型");
        }
        return invokeQianwen(request);
    }

    private boolean checkModel(QianwenRequest request) {
        if (Constants.MODEL_QWEN_TURBO.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_PLUS.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_MAX.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_V1.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_MAX.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_PLUS.equalsIgnoreCase(request.getModel())) {
            return true;
        }
        return false;
    }

    private String invokeQianwen(QianwenRequest request) {
        String body = JSON.toJSONString(request);
        String url = Constants.HTTP_ENDPOINT_QIANWEN;
        if (Constants.MODEL_QWEN_VL_V1.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_PLUS.equalsIgnoreCase(request.getModel())
                || Constants.MODEL_QWEN_VL_MAX.equalsIgnoreCase(request.getModel())) {
            url = Constants.HTTP_ENDPOINT_QIANWEN_VL;
        }
        String token = "Bearer " + qianwenProperties.getApiKey();
        return HttpUtils.post(url, body, token);
    }

}
