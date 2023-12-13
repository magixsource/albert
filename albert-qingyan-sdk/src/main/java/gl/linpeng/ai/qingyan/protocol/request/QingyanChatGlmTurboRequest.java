package gl.linpeng.ai.qingyan.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * SSE接口请求参数
 */
public class QingyanChatGlmTurboRequest extends QingyanRequest {
    /**
     * 调用对话模型时，将当前对话信息列表作为提示输入给模型;
     * 按照 {"role": "user", "content": "你好"} 的键值对形式进行传参;
     * 总长度超过模型最长输入限制后会自动截断，需按时间由旧到新排序
     */
    private List<Message> prompt;

    /**
     * 采样温度，控制输出的随机性，必须为正数
     * 取值范围是：(0.0,1.0]，不能等于 0,默认值为 0.95
     * 值越大，会使输出更随机，更具创造性；值越小，输出会更加稳定或确定
     * 建议您根据应用场景调整 top_p 或 temperature 参数，但不要同时调整两个参数
     */
    private Float temperature;
    /**
     * 用温度取样的另一种方法，称为核取样
     * 取值范围是：(0.0, 1.0) 开区间，不能等于 0 或 1，默认值为 0.7
     * 模型考虑具有 top_p 概率质量tokens的结果
     * 例如：0.1 意味着模型解码器只考虑从前 10% 的概率的候选集中取tokens
     * 建议您根据应用场景调整 top_p 或 temperature 参数，但不要同时调整两个参数
     */
    private Float topP;
    /**
     * 由用户端传参，需保证唯一性；用于区分每次请求的唯一标识，用户端不传时平台会默认生成。
     */
    private String requestId;
    /**
     * SSE接口调用时，用于控制每次返回内容方式是增量还是全量，不提供此参数时默认为增量返回
     * - true 为增量返回
     * - false 为全量返回
     */
    private Boolean incremental;
    /**
     * 用于控制每次返回内容的类型，空或者没有此字段时默认按照json_string返回
     * - json_string 返回标准的 JSON 字符串
     * - text 返回原始的文本内容
     */
    @JSONField(name = "return_type")
    private String returnType;
    /**
     * 用于控制请求时的外部信息引用，目前用于控制是否引用外部信息，空或者没有此字段时默认开启搜索，传参格式
     * {"enable": "true", "search_query": "历史"}
     */
    private Ref ref;

    public List<Message> getPrompt() {
        return prompt;
    }

    public void setPrompt(List<Message> prompt) {
        this.prompt = prompt;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getTopP() {
        return topP;
    }

    public void setTopP(Float topP) {
        this.topP = topP;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Boolean getIncremental() {
        return incremental;
    }

    public void setIncremental(Boolean incremental) {
        this.incremental = incremental;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Ref getRef() {
        return ref;
    }

    public void setRef(Ref ref) {
        this.ref = ref;
    }
}
