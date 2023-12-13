package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;
import gl.linpeng.ai.yiyan.protocol.request.FunctionCall;

/**
 * ErnieBot对话返回
 */
public class YiyanResponseErnieBot extends YiyanResponseErnieBot4 {

    /**
     * 适用于ErnieBOT模型:由模型生成的函数调用，包含函数名称，和调用参数
     */
    @JSONField(name = "function_call")
    private FunctionCall functionCall;

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }
}
