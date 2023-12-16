package gl.linpeng.ai.qianwen.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;
import gl.linpeng.ai.commons.protocol.request.AlbertParameters;

import java.util.List;

/**
 * 请求参数
 */
public class Parameters extends AlbertParameters {
    /**
     * "text"表示旧版本的text
     * "message"表示兼容openai的message
     */
    @JSONField(name = "result_format")
    private String resultFormat;
    /**
     * 生成时，随机数的种子，用于控制模型生成的随机性。如果使用相同的种子，每次运行生成的结果都将相同；
     * 当需要复现模型的生成结果时，可以使用相同的种子。seed参数支持无符号64位整数类型。默认值 1234
     */
    private Integer seed;

    /**
     * 用于控制流式输出模式，默认False，即后面内容会包含已经输出的内容；设置为True，将开启增量输出模式，
     * 后面输出不会包含已经输出的内容，您需要自行拼接整体输出，参考流式输出示例代码。
     * 该参数只能与stream输出模式配合使用。
     */
    @JSONField(name = "incremental_output")
    private Boolean incrementalOutput;

    public String getResultFormat() {
        return resultFormat;
    }

    public void setResultFormat(String resultFormat) {
        this.resultFormat = resultFormat;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }


    public Boolean getIncrementalOutput() {
        return incrementalOutput;
    }

    public void setIncrementalOutput(Boolean incrementalOutput) {
        this.incrementalOutput = incrementalOutput;
    }
}
