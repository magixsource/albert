package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;
import gl.linpeng.ai.qianwen.protocol.request.Message;

/**
 * 入参result_format=message时候的返回值
 */
public class Choice {
    /**
     * 停止原因，null：生成过程中
     * stop：stop token导致结束
     * length：生成长度导致结束
     */
    @JSONField(name = "finish_reason")
    private String finishReason;
    private Message message;

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
