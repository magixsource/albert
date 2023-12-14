package gl.linpeng.ai.qianwen;

import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.Input;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;

public class QianwenTests {

    public static void main(String[] args) {
        QianwenClient client = new QianwenClient();
        QianwenRequest request = new QianwenRequest();
        request.setModel(Constants.MODEL_QWEN_MAX);
        Input input = new Input();
        input.setPrompt("你好");
        request.setInput(input);
        client.invoke(request);
    }
}
