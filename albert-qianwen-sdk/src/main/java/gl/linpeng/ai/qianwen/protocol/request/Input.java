package gl.linpeng.ai.qianwen.protocol.request;

import java.util.List;

public class Input {
    /**
     * 用户当前输入的期望模型执行指令，支持中英文。
     */
    private String prompt;
    /**
     * 用户与模型的对话历史
     */
    private List<Message> messages;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
