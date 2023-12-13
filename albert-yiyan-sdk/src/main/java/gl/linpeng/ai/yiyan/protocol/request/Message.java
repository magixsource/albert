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
    /**
     * 适用于ErnieBOT模型: message作者；当role=function时，必填，且是响应内容中function_call中的name
     */
    private String name;
    /**
     * 适用于ErnieBOT模型: 函数调用，function call场景下第一轮对话的返回，第二轮对话作为历史信息在message中传入
     */
    private FunctionCall functionCall;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }
}
