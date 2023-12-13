package gl.linpeng.ai.taichu;

import gl.linpeng.ai.taichu.protocol.request.TaichuRequest8B;

public class TaichuTests {

    public static void main(String[] args) {
        TaichuClient client = new TaichuClient();
        TaichuRequest8B request8B = new TaichuRequest8B();
        request8B.setQuestion("你好");
        client.invoke(request8B);
    }
}
