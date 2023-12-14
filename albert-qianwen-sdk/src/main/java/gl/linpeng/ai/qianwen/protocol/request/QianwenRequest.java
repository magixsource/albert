package gl.linpeng.ai.qianwen.protocol.request;

public class QianwenRequest {
    /**
     * 指明需要调用的模型，目前可选 qwen-turbo、qwen-plus、qwen-max、qwen-max-1201和qwen-max-longcontext
     */
    private String model;
    /**
     * 用户输入指令
     */
    private Input input;
    /**
     * 大数据模型参数
     */
    private Parameters parameters;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
