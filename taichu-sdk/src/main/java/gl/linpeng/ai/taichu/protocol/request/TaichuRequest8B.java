package gl.linpeng.ai.taichu.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 太初8B模型请求对象
 */
public class TaichuRequest8B extends TaichuRequest {
    /**
     * 是否流式输出，默认true
     */
    @JSONField(name = "do_stream")
    private Boolean doStream;

    public Boolean getDoStream() {
        return doStream;
    }

    public void setDoStream(Boolean doStream) {
        this.doStream = doStream;
    }
}
