package gl.linpeng.ai.qingyan;


import gl.linpeng.ai.qingyan.config.QingyanProperties;
import gl.linpeng.ai.qingyan.protocol.request.Message;
import gl.linpeng.ai.qingyan.protocol.request.QingyanChatGlmTurboRequest;

import java.util.ArrayList;
import java.util.List;

public class QingyanTests {

    public static void main(String[] args) {
        QingyanProperties qingyanProperties = new QingyanProperties();
        qingyanProperties.setApiKey("mock_apikey");
        qingyanProperties.setApiSecret("mock_apisecret");
        QingyanClient client = new QingyanClient(qingyanProperties);
        QingyanChatGlmTurboRequest request = new QingyanChatGlmTurboRequest();
        List<Message> messages = new ArrayList<>(2);
        Message message = new Message("user", "你好");
        messages.add(message);
        request.setPrompt(messages);
        client.invoke(request);
    }
}
