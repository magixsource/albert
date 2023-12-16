package gl.linpeng.ai.commons.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 通用返回对象
 * 注意: 这里暂时不支持SSE流式消息
 */
public class AlbertResponse {

    /**
     * 请求返回码 200 成功 500 失败
     */
    private Integer code;
    /**
     * 请求返回错误信息
     */
    private String message;

    /**
     * 请求的系统唯一码
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * 模型生成的文本内容
     */
    private AlbertOutput output;

    /**
     * 模型调用统计情况
     */
    private AlbertUsage usage;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlbertOutput getOutput() {
        return output;
    }

    public void setOutput(AlbertOutput output) {
        this.output = output;
    }

    public AlbertUsage getUsage() {
        return usage;
    }

    public void setUsage(AlbertUsage usage) {
        this.usage = usage;
    }

    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
