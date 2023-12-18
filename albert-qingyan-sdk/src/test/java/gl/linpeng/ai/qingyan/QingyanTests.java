package gl.linpeng.ai.qingyan;


import gl.linpeng.ai.commons.protocol.request.AlbertInput;
import gl.linpeng.ai.commons.protocol.request.AlbertRequest;
import gl.linpeng.ai.qingyan.config.QingyanProperties;

public class QingyanTests {

    public static void main(String[] args) {
        QingyanProperties qingyanProperties = new QingyanProperties();
        qingyanProperties.setApiKey("mock_apikey");
        qingyanProperties.setApiSecret("mock_apisecret");
        QingyanClient client = new QingyanClient(qingyanProperties);
        AlbertRequest request = new AlbertRequest();
        AlbertInput input = new AlbertInput();
        input.setPrompt("你好");
        request.setInput(input);
        client.invoke(request);
    }
}
