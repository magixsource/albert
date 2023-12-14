package gl.linpeng.ai.qingyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * tokens 数量统计
 */
public class Usage {
    /**
     * 问题 tokens 数量
     */
    @JSONField(name = "prompt_tokens")
    private Integer promptTokens;
    /**
     * 回答 tokens 数量
     */
    @JSONField(name = "completion_tokens")
    private Integer completionTokens;
    /**
     * 总 tokens 数量
     */
    @JSONField(name = "total_tokens")
    private Integer totalTokens;

    public Integer getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Integer getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }
}
