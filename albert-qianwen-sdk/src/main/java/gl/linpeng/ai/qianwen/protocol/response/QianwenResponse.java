package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

public class QianwenResponse {
    /**
     * 请求的系统唯一码
     */
    @JSONField(name = "requestId")
    private String requestId;
    /**
     * 模型生成的文本内容
     */
    private Output output;
    /**
     * 调用统计情况
     */
    private Usage usage;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
