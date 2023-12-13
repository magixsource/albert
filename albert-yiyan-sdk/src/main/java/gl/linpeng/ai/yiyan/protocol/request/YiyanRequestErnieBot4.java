package gl.linpeng.ai.yiyan.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * ErnieBot4请求
 */
public class YiyanRequestErnieBot4 extends YiyanRequest {
    /**
     * 聊天上下文信息。说明：
     * （1）messages成员不能为空，1个成员表示单轮对话，多个成员表示多轮对话
     * （2）最后一个message为当前请求的信息，前面的message为历史对话信息
     * （3）必须为奇数个成员，成员中message的role必须依次为user、assistant
     * （4）最后一个message的content长度（即此轮对话的问题）不能超过4800个字符，且不能超过2000 tokens
     * （5）如果messages中content总长度大于4800个字符或2000 tokens，系统会依次遗忘最早的历史会话，直到content的总长度不超过4800个字符且不超过2000 tokens
     */
    private List<Message> messages;
    /**
     * 说明：
     * （1）较高的数值会使输出更加随机，而较低的数值会使其更加集中和确定
     * （2）默认0.8，范围 (0, 1.0]，不能为0
     * （3）建议该参数和top_p只设置1个
     * （4）建议top_p和temperature不要同时更改
     */
    private Float temperature;
    /**
     * 说明：
     * （1）影响输出文本的多样性，取值越大，生成文本的多样性越强
     * （2）默认0.8，取值范围 [0, 1.0]
     * （3）建议该参数和temperature只设置1个
     * （4）建议top_p和temperature不要同时更改
     */
    @JSONField(name = "top_p")
    private Float topP;
    /**
     * 通过对已生成的token增加惩罚，减少重复生成的现象。说明：
     * （1）值越大表示惩罚越大
     * （2）默认1.0，取值范围：[1.0, 2.0]
     */
    @JSONField(name = "penalty_score")
    private Float penaltyScore;
    /**
     * 是否以流式接口的形式返回数据，默认false
     */
    private Boolean stream;

    /**
     * 模型人设，主要用于人设设定，例如，你是xxx公司制作的AI助手，长度限制1024个字符
     */
    private String system;
    /**
     * 生成停止标识，当模型生成结果以stop中某个元素结尾时，停止文本生成。说明：
     * （1）每个元素长度不超过20字符
     * （2）最多4个元素
     */
    private List<String> stop;
    /**
     * 是否强制关闭实时搜索功能，默认false，表示不关闭
     */
    @JSONField(name = "disable_search")
    private Boolean disableSearch;
    /**
     * 是否开启上角标返回，说明：
     * （1）开启后，有概率触发搜索溯源信息search_info，search_info内容见响应参数介绍
     * （2）默认false，不开启
     */
    @JSONField(name = "enable_citation")
    private Boolean enableCitation;
    /**
     * 表示最终用户的唯一标识符，可以监视和检测滥用行为，防止接口恶意调用
     */
    @JSONField(name = "user_id")
    private String userId;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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

    public Float getPenaltyScore() {
        return penaltyScore;
    }

    public void setPenaltyScore(Float penaltyScore) {
        this.penaltyScore = penaltyScore;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public Boolean getDisableSearch() {
        return disableSearch;
    }

    public void setDisableSearch(Boolean disableSearch) {
        this.disableSearch = disableSearch;
    }

    public Boolean getEnableCitation() {
        return enableCitation;
    }

    public void setEnableCitation(Boolean enableCitation) {
        this.enableCitation = enableCitation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
