package gl.linpeng.ai.qingyan.protocol.response;

/**
 * 元数据: finish 事件时，通过 meta 发送更多信息，比如数量
 */
public class Meta {
    /**
     * 统计信息 usage
     */
    private Usage usage;

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
