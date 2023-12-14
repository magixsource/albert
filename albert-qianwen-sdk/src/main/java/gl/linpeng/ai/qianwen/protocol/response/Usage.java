package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 调用统计情况
 */
public class Usage {
    /**
     * 本次请求算法输出内容的 token 数目
     */
    @JSONField(name = "output_tokens")
    private Integer outputTokens;
    /**
     * 本次请求输入内容的 token 数目。在打开了搜索的情况下，输入的 token 数目因为还需要添加搜索相关内容支持，所以会超出客户在请求中的输入
     */
    @JSONField(name = "input_tokens")
    private Integer inputTokens;

    public Integer getOutputTokens() {
        return outputTokens;
    }

    public void setOutputTokens(Integer outputTokens) {
        this.outputTokens = outputTokens;
    }

    public Integer getInputTokens() {
        return inputTokens;
    }

    public void setInputTokens(Integer inputTokens) {
        this.inputTokens = inputTokens;
    }
}
