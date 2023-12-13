package gl.linpeng.ai.yiyan;

import gl.linpeng.ai.yiyan.protocol.request.Message;
import gl.linpeng.ai.yiyan.protocol.request.YiyanRequestErnieBot;

import java.util.List;

public class YiyanTests {

    public static void main(String[] args) {
        YiyanClient client = new YiyanClient();
        YiyanRequestErnieBot request = new YiyanRequestErnieBot();
        Message message = new Message();
        message.setContent("你好,请介绍你自己");
        List<Message> messages = List.of(message);
        request.setMessages(messages);
        client.invoke(request);
    }
}
