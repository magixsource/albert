package gl.linpeng.ai.qingyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {
    /**
     * 用户在客户端请求时提交的任务编号或者平台生成的任务编号
     */
    @JSONField(name = "request_id")
    private String requestId;
    /**
     * 智谱AI开放平台生成的任务订单号，调用请求结果接口时请使用此订单号
     */
    @JSONField(name = "task_id")
    private String taskId;
    /**
     * 处理状态，PROCESSING（处理中），SUCCESS（成功），FAIL（失败）
     * 注：处理中状态需通过查询获取结果
     */
    @JSONField(name = "task_status")
    private String taskStatus;

    /**
     * 异步结果查询适用: 对话的模型输出内容，目前只返回一条（后续会支持候选模式）
     */
    @JSONField(name = "choices")
    private List<Choice> choices;

    /**
     * 本次模型调用的 tokens 数量统计
     */
    private Usage usage;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
