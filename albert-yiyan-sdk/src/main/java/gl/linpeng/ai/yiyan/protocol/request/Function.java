package gl.linpeng.ai.yiyan.protocol.request;

import java.util.List;

/**
 * ErnieBot 函数
 */
public class Function {
    /**
     * 函数名称
     */
    private String name;
    /**
     * 函数描述
     */
    private String description;
    /**
     * 函数请求参数，说明：
     * （1）JSON Schema 格式，参考JSON Schema描述
     * （2）如果函数没有请求参数，parameters值格式如下：
     * {"type": "object","properties": {}}
     */
    private Object parameters;
    /**
     * 函数响应参数，JSON Schema 格式
     */
    private Object responses;
    /**
     * function调用的一些历史示例
     */
    private List<Example> examples;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    public Object getResponses() {
        return responses;
    }

    public void setResponses(Object responses) {
        this.responses = responses;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }
}
