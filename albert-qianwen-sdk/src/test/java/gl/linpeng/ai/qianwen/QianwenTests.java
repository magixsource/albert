package gl.linpeng.ai.qianwen;

import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.Input;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;

public class QianwenTests {

    public static void main(String[] args) {
        QianwenProperties qianwenProperties = new QianwenProperties();
        qianwenProperties.setApiKey("mock-apikey");
        QianwenClient client = new QianwenClient(qianwenProperties);
        QianwenRequest request = new QianwenRequest();
        request.setModel(Constants.MODEL_QWEN_MAX);
        Input input = new Input();
        input.setPrompt("你好");
        request.setInput(input);
        client.invoke(request);
    }
}
