package gl.linpeng.ai.qingyan.protocol.response;

/**
 * 话的模型输出内容，目前只返回一条（后续会支持候选模式）
 */
public class Choice {
    /**
     * 当前对话的角色，目前默认为 assistant（模型）
     */
    private String role;
    /**
     * 对话的内容
     */
    private String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
