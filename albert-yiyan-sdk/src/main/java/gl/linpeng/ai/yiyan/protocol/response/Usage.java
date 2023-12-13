package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Usage统计信息
 */
public class Usage {
    /**
     * 问题token数
     */
    @JSONField(name = "prompt_tokens")
    private int promptTokens;
    /**
     * 回答token数
     */
    @JSONField(name = "completion_tokens")
    private int completionTokens;
    /**
     * 总的token数
     */
    @JSONField(name = "total_tokens")
    private int totalTokens;

    /**
     * 适用于ErnieBOT模型: plugin消耗的tokens
     */
    @JSONField(name = "plugins")
    private List<PluginUsage> plugins;

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    public List<PluginUsage> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<PluginUsage> plugins) {
        this.plugins = plugins;
    }
}
