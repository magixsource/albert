package gl.linpeng.ai.commons.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 模型生成的文本内容
 */
public class AlbertOutput {
    /**
     * 模型生成的文本内容
     */
    private String text;

    /**
     * 有三种情况：正在生成时为null，生成结束时如果由于停止token导致则为stop，生成结束时如果因为生成长度过长导致则为length。
     */
    @JSONField(name = "finish_reason")
    private String finishReason;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
}
