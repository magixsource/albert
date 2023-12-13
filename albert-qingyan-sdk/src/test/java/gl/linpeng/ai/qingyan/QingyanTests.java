package gl.linpeng.ai.qingyan;


import gl.linpeng.ai.qingyan.protocol.request.Message;
import gl.linpeng.ai.qingyan.protocol.request.QingyanChatGlmTurboRequest;

import java.util.ArrayList;
import java.util.List;

public class QingyanTests {

    public static void main(String[] args) {
        QingyanClient client = new QingyanClient();
        QingyanChatGlmTurboRequest request = new QingyanChatGlmTurboRequest();
        List<Message> messages = new ArrayList<>(2);
        Message message = new Message("user", "你好");
        messages.add(message);
        request.setPrompt(messages);
        client.invoke(request);
    }
}
