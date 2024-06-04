package gl.linpeng.ai.qianwen.protocol.request;

import gl.linpeng.ai.commons.protocol.request.AlbertRequest;

public class QianwenRequest extends AlbertRequest<Input, Parameters> {
    /**
     * 指明需要调用的模型，目前可选 qwen-turbo、qwen-plus、qwen-max、qwen-max-1201和qwen-max-longcontext
     */
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
