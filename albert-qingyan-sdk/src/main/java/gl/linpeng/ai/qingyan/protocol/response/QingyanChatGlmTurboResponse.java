package gl.linpeng.ai.qingyan.protocol.response;

public class QingyanChatGlmTurboResponse extends QingyanResponse {
    /**
     * 消息唯一标识
     */
    private String id;
    /**
     * 消息类型，add 增量，finish 结束，error 错误，interrupted 中断
     */
    private String event;
    /**
     * 具体的消息内容
     */
    private String data;
    /**
     * finish 事件时，通过 meta 发送更多信息，比如数量
     */
    private Meta meta;

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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
