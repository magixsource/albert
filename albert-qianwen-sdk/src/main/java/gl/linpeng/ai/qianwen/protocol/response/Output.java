package gl.linpeng.ai.qianwen.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;
import gl.linpeng.ai.commons.protocol.response.AlbertOutput;

import java.util.List;

/**
 * 模型生成的文本内容
 */
public class Output extends AlbertOutput {

    /**
     * 入参result_format=message时候的返回值
     */
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
