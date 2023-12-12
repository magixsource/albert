package gl.linpeng.ai.taichu.response;

/**
 * 流式响应体
 * 响应格式为标准 Event Stream 响应头 Content-Type 为 text/event-stream, 使用SSE(Server-Sent Events)协议
 */
public class TaichuStreamResponse {
    /**
     * 消息唯一标识
     */
    private String id;
    /**
     * 消息类型，add：增量消息，finish：结束，error：错误
     */
    private String event;

    /**
     * 消息具体内容 ，event为finish时内容为上下文完整信息
     */
    private String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
