package gl.linpeng.ai.qingyan.constant;

/**
 * Taichu constant
 */
public class Constants {
    /**
     * SSE调用的HTTP端点
     */
    public static final String HTTP_ENDPOINT_CHAT_GLM_TURBO = "https://open.bigmodel.cn/api/paas/v3/model-api/chatglm_turbo/sse-invoke";
    /**
     * 异步调用的HTTP端点
     */
    public static final String HTTP_ENDPOINT_CHAT_GLM_TURBO_ASYNC = "https://open.bigmodel.cn/api/paas/v3/model-api/chatglm_turbo/async-invoke";
    /**
     * 查询结果的HTTP端点
     */
    public static final String HTTP_ENDPOINT_CHAT_GLM_TURBO_ASYNC_RESULT = "https://open.bigmodel.cn/api/paas/v3/model-api/-/async-invoke";

    /**
     * 同步调用的HTTP端点
     */
    public static final String HTTP_ENDPOINT_CHAT_GLM_TURBO_SYNC = "https://open.bigmodel.cn/api/paas/v3/model-api/chatglm_turbo/invoke";


    public static final String TOKEN_KEY = "albert";


    public static final int HTTP_STATUS_SUCCESS = 200;
    public static final int HTTP_STATUS_ERROR = 500;
}
