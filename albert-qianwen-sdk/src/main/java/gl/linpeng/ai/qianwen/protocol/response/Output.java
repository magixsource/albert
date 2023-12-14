package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 模型生成的文本内容
 */
public class Output {
    /**
     * 模型生成的文本内容
     */
    private String text;
    /**
     * 有三种情况：正在生成时为null，生成结束时如果由于停止token导致则为stop，生成结束时如果因为生成长度过长导致则为length。
     */
    @JSONField(name = "finish_reason")
    private String finishReason;
    /**
     * 入参result_format=message时候的返回值
     */
    private List<Choice> choices;

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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
