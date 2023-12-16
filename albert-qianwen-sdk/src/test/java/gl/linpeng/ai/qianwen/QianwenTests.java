package gl.linpeng.ai.qianwen;

import gl.linpeng.ai.commons.protocol.request.AlbertInput;
import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;

public class QianwenTests {

    public static void main(String[] args) {
        QianwenProperties qianwenProperties = new QianwenProperties();
        qianwenProperties.setApiKey("mock_apikey");
        QianwenClient client = new QianwenClient(qianwenProperties);
        QianwenRequest request = new QianwenRequest();
        request.setModel(Constants.MODEL_QWEN_MAX);
        AlbertInput input = new AlbertInput();
        input.setPrompt("你好");
        request.setInput(input);
        QianwenResponse response = client.invoke(request);
        System.out.println("请求响应："+ response.getOutput().getText());
    }
}
