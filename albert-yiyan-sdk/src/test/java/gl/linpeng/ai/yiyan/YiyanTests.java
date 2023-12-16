package gl.linpeng.ai.yiyan;

import gl.linpeng.ai.yiyan.config.YiyanProperties;
import gl.linpeng.ai.yiyan.protocol.request.Message;
import gl.linpeng.ai.yiyan.protocol.request.YiyanErnieBotRequest;

import java.util.ArrayList;
import java.util.List;

public class YiyanTests {

    public static void main(String[] args) {
        YiyanProperties properties = new YiyanProperties();
        properties.setApiKey("your_apikey");
        properties.setApiSecret("your_apiSecret");
        YiyanClient client = new YiyanClient(properties);
        YiyanErnieBotRequest request = new YiyanErnieBotRequest();
        Message message = new Message();
        message.setContent("你好,请介绍你自己");
        // List<Message> messages = List.of(message);
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        request.setMessages(messages);
        client.invoke(request);
    }
}
