package gl.linpeng.ai.commons.protocol.request;

/**
 * 通用请求
 */
public class AlbertRequest<I extends AlbertInput, P extends AlbertParameters> {
    /**
     * 用户输入指令
     */
    private I input;
    /**
     * 大数据模型参数
     */
    private P parameters;

    public I getInput() {
        return input;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public P getParameters() {
        return parameters;
    }

    public void setParameters(P parameters) {
        this.parameters = parameters;
    }
}
