package gl.linpeng.ai.qianwen.constant;

/**
 * Qianwen constant
 */
public class Constants {
    // -----HTTP Endpoint------
    public static final String HTTP_ENDPOINT_QIANWEN = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

    // -----Qianwen Model------
    public static final String MODEL_QWEN_TURBO = "qwen-turbo";
    public static final String MODEL_QWEN_PLUS = "qwen-plus";
    public static final String MODEL_QWEN_MAX = "qwen-max";
    public static final String MODEL_QWEN_MAX_1201 = "qwen-max-1201";
    public static final String MODEL_QWEN_MAX_LONGCONTEXT = "qwen-max-longcontext";


    // -----HTTP Status------
    public static final int HTTP_STATUS_SUCCESS = 200;
    public static final int HTTP_STATUS_ERROR = 500;
}
