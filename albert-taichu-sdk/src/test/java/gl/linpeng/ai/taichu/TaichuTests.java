package gl.linpeng.ai.taichu;

import gl.linpeng.ai.taichu.config.TaichuProperties;
import gl.linpeng.ai.taichu.protocol.request.Taichu8BRequest;

public class TaichuTests {

    public static void main(String[] args) {
        TaichuProperties properties = new TaichuProperties();
        properties.setApiKey("your_apikey");
        TaichuClient client = new TaichuClient(properties);
        Taichu8BRequest request8B = new Taichu8BRequest();
        request8B.setQuestion("你好");
        client.invoke(request8B);
    }
}
