package gl.linpeng.ai.commons.protocol.request;

import java.util.List;

/**
 * 用户输入指令
 */
public class AlbertInput<M extends AlbertMessage> {
    /**
     * 用户期望模型执行的指令
     */
    private String prompt;

    /**
     * 用户与模型的对话历史
     */
    private List<M> messages;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<M> getMessages() {
        return messages;
    }
    public void setMessages(List<M> messages) {
        this.messages = messages;
    }
}
