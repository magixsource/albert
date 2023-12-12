package gl.linpeng.ai.taichu.protocol.response;

/**
 * 非流式响应体
 */
public class TaichuResponse {
    /**
     * 错误码，非0异常
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        /**
         * 返回的文本内容
         */
        private String content;
        /**
         * 问答上下文，后续请求使用该值带入参数
         */
        private String context;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }
}


