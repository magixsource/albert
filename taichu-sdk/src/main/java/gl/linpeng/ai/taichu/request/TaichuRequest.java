package gl.linpeng.ai.taichu.request;

import com.alibaba.fastjson.annotation.JSONField;

public class TaichuRequest {

    @JSONField(name = "api_key")
    private String apiKey;
    /**
     * 模型code
     */
    @JSONField(name = "model_code")
    private String modelCode;
    /**
     * 用户输入信息
     */
    private String question;

    /**
     * 对于8B模型:多轮对话上下文信息，首次请求不需要带，后续请求使用接口返回的值， do_stream=true时，context为finish事件的data值，do_stream=false时，context为接口返回的context值
     * 对于10B模型:上下文信息，首次请求不需要带，后续请求使用接口返回的context值，当picture发生变化时，context需要重置为空
     */
    private String context;
    /**
     * 生成过程中的温度值，取值范围[0.01,1.00] 闭区间，默认值为 1.0,调节最小细粒度为0.01
     */
    private Float temperature;
    /**
     * 生成过程中的token几率阈值取值范围是：(0.0, 1.0) 开区间，默认值为 0.9,调节最小细粒度为0.1
     */
    @JSONField(name = "top_p")
    private Float topP;
    /**
     * 生成过程中的惩罚值取值范围是：(1.0, 2.0) 开区间，默认值为 1.0,调节最小细粒度为0.1
     */
    @JSONField(name = "repetition_penalty")
    private Float repetitionPenalty;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public Float getRepetitionPenalty() {
        return repetitionPenalty;
    }

    public void setRepetitionPenalty(Float repetitionPenalty) {
        this.repetitionPenalty = repetitionPenalty;
    }
}
