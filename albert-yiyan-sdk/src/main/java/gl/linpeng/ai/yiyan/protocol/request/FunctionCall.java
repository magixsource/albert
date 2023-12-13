package gl.linpeng.ai.yiyan.protocol.request;

/**
 * 函数调用
 */
public class FunctionCall {
    /**
     * 触发的function名
     */
    private String name;
    /**
     * 请求参数
     */
    private String arguments;
    /**
     * 模型思考过程
     */
    private String thoughts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }
}
