package gl.linpeng.ai.yiyan.protocol.request;

/**
 * 机器人对话消息
 */
public class Message {
    /**
     * 对话内容
     */
    private String content;
    /**
     * 当前支持以下：
     * user: 表示用户
     * assistant: 表示对话助手
     */
    private String role;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
