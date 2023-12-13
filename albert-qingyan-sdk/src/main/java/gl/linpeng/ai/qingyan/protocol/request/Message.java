package gl.linpeng.ai.qingyan.protocol.request;

public class Message {
    /**
     * 本条信息作者的角色，可选择user 或 assistant
     * - user 指用户角色输入的信息
     * - assistant 指模型返回的信息
     */
    private String role;
    /**
     * 本条信息的具体内容
     */
    private String content;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
