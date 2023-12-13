package gl.linpeng.ai.yiyan.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 一言响应(Base on ErnieBotTurbo)
 */
public class YiyanResponse {
    /**
     * 本轮对话的id
     */
    private String id;
    /**
     * 回包类型
     * chat.completion：多轮对话返回
     */
    private String object;
    /**
     * 时间戳
     */
    @JSONField(name = "created")
    private int created;
    /**
     * 表示当前子句的序号。只有在流式接口模式下会返回该字段
     */
    @JSONField(name = "sentence_id")
    private int sentenceId;
    /**
     * 表示当前子句是否是最后一句。只有在流式接口模式下会返回该字段
     */
    @JSONField(name = "is_end")
    private boolean isEnd;
    /**
     * 当前生成的结果是否截断，true：是，false：否
     */
    @JSONField(name = "is_truncated")
    private boolean isTruncated;
    /**
     * 对话返回结果
     */
    private String result;
    /**
     * 表示用户输入是否存在安全，是否关闭当前会话，清理历史会话信息
     * true：是，表示用户输入存在安全风险，建议关闭当前会话，清理历史会话信息
     * false：否，表示用户输入无安全风险
     */
    @JSONField(name = "need_clear_history")
    private boolean needClearHistory;
    /**
     * 当need_clear_history为true时，此字段会告知第几轮对话有敏感信息，如果是当前问题，ban_round=-1
     */
    @JSONField(name = "ban_round")
    private int banRound;
    /**
     * token统计信息
     */
    private Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isTruncated() {
        return isTruncated;
    }

    public void setTruncated(boolean truncated) {
        isTruncated = truncated;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isNeedClearHistory() {
        return needClearHistory;
    }

    public void setNeedClearHistory(boolean needClearHistory) {
        this.needClearHistory = needClearHistory;
    }

    public int getBanRound() {
        return banRound;
    }

    public void setBanRound(int banRound) {
        this.banRound = banRound;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
