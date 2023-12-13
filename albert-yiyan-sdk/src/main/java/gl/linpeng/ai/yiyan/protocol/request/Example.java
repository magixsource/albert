package gl.linpeng.ai.yiyan.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ErnieBot 函数调用示例
 */
public class Example {
    /**
     * 当前支持以下：
     * user: 表示用户
     * assistant: 表示对话助手
     * function: 表示函数
     */
    private String role;
    /**
     * 对话内容，说明：
     * （1）当前message存在function_call，且role="assistant"时可以为空，其他场景不能为空
     * （2）最后一个message对应的content不能为blank字符，包含空格、"\n"、“\r”、“\f”等
     */
    private String content;
    /*
     * message作者；当role=function时，必填，且是响应内容中function_call中的name
     */
    private String name;
    /**
     * 函数调用，function call场景下第一轮对话的返回，第二轮对话作为历史信息在message中传入
     */
    @JSONField(name = "function_call")
    private FunctionCall functionCall;

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
