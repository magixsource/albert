package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;
import gl.linpeng.ai.commons.protocol.request.AlbertMessage;

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
    private AlbertMessage message;

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public AlbertMessage getMessage() {
        return message;
    }
    public void setMessage(AlbertMessage message) {
        this.message = message;
    }
}
