package gl.linpeng.ai.yiyan.protocol.request;

import java.util.List;

/**
 * ErnieBot请求
 */
public class YiyanErnieBotRequest extends YiyanErnieBot4Request {

    /**
     * 一个可触发函数的描述列表，说明：
     * （1）支持的function数量无限制
     * （2）functions和Messages的总长度不能超过14300个字符
     */
    private List<Function> functions;

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
}
