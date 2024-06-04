package gl.linpeng.ai.qianwen.constant;

/**
 * Qianwen constant
 */
public class Constants {
    // -----HTTP Endpoint------
    public static final String HTTP_ENDPOINT_QIANWEN = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";
    public static final String HTTP_ENDPOINT_QIANWEN_VL = "https://dashscope.aliyuncs.com/api/v1/services/aigc/multimodal-generation/generation";
    // -----Qianwen Model------
    public static final String MODEL_QWEN_TURBO = "qwen-turbo";
    public static final String MODEL_QWEN_PLUS = "qwen-plus";
    public static final String MODEL_QWEN_MAX = "qwen-max";
    public static final String MODEL_QWEN_MAX_1201 = "qwen-max-1201";
    public static final String MODEL_QWEN_MAX_LONGCONTEXT = "qwen-max-longcontext";

    public static final String MODEL_QWEN_VL_V1 = "qwen-vl-chat-v1";
    // 大规模视觉语言模型增强版
    public static final String MODEL_QWEN_VL_PLUS ="qwen-vl-plus";
    // 超大规模视觉语言模型
    public static final String MODEL_QWEN_VL_MAX="qwen-vl-max";


    // -----HTTP Status------
    public static final int HTTP_STATUS_SUCCESS = 200;
    public static final int HTTP_STATUS_ERROR = 500;
}
