package gl.linpeng.ai.commons.protocol.request;

/**
 * 用户与模型的对话历史
 */
public class AlbertMessage {
    /**
     * 用户与模型的对话历史，对话接口未来都会有message传输，不过prompt和history会持续兼容，
     * list中的每个元素形式为{"role":角色, "content": 内容}。角色当前可选值：system、user、assistant。未来可以扩展到更多role。
     */
    private String role;
    /**
     * 对话内容
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
