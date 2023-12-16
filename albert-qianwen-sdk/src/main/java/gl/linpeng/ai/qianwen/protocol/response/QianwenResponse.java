package gl.linpeng.ai.qianwen.protocol.response;

import gl.linpeng.ai.commons.protocol.response.AlbertResponse;

public class QianwenResponse extends AlbertResponse {

    /**
     * 模型生成的文本内容
     */
    private Output output;


    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

}
