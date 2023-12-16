package gl.linpeng.ai.commons.protocol.request;

/**
 * 通用请求
 */
public class AlbertRequest {
    /**
     * 用户输入指令
     */
    private AlbertInput input;
    /**
     * 大数据模型参数
     */
    private AlbertParameters parameters;

    public AlbertInput getInput() {
        return input;
    }

    public void setInput(AlbertInput input) {
        this.input = input;
    }

    public AlbertParameters getParameters() {
        return parameters;
    }

    public void setParameters(AlbertParameters parameters) {
        this.parameters = parameters;
    }
}
