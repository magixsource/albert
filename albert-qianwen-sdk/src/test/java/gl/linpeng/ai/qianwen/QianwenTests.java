package gl.linpeng.ai.qianwen;

import gl.linpeng.ai.qianwen.config.QianwenProperties;
import gl.linpeng.ai.qianwen.constant.Constants;
import gl.linpeng.ai.qianwen.protocol.request.Content;
import gl.linpeng.ai.qianwen.protocol.request.Input;
import gl.linpeng.ai.qianwen.protocol.request.Message;
import gl.linpeng.ai.qianwen.protocol.request.QianwenRequest;
import gl.linpeng.ai.qianwen.protocol.response.QianwenResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QianwenTests {

    @Test
    public void testInvokeQianwen() {
        QianwenProperties qianwenProperties = new QianwenProperties();
        qianwenProperties.setApiKey("mock_apikey");
        QianwenClient client = new QianwenClient(qianwenProperties);
        QianwenRequest request = new QianwenRequest();
        request.setModel(Constants.MODEL_QWEN_MAX);
        Input input = new Input();
        input.setPrompt("你好");
        request.setInput(input);
        QianwenResponse response = client.invoke(request);
        Assert.assertNotEquals(200, response.getCode().intValue());
        System.out.println("请求响应：" + response.getOutput().getText());
    }

    @Test
    public void testInvokeQianwenVl() {
        QianwenProperties qianwenProperties = new QianwenProperties();
        qianwenProperties.setApiKey("mock_key");
        QianwenClient client = new QianwenClient(qianwenProperties);
        QianwenRequest request = new QianwenRequest();
        request.setModel(Constants.MODEL_QWEN_VL_V1);
        Input input = new Input();
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        message.setRole("user");
        List<Content> contents = new ArrayList<>();
        Content content = new Content();
        content.setImage("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        contents.add(content);
        Content text = new Content();
        text.setText("图中的骑行服主要由哪些颜色组成?回答要求极简洁，只说颜色即可,回答时不同的颜色以逗号分隔");
        contents.add(text);
        message.setContent(contents);
        messages.add(message);
        input.setMessages(messages);
        request.setInput(input);
        QianwenResponse response = client.invoke(request);
        Assert.assertNotNull(response.getOutput().getChoices().get(0).getMessage());
        System.out.println("请求响应：" + response.getOutput().getChoices().get(0).getMessage().getContent());


    }
}
