package gl.linpeng.ai.qianwen.config;


import org.springframework.beans.factory.annotation.Value;

/**
 * Qianwen config
 */
public class QianwenProperties {

    @Value("${albert.qianwen.apikey:mock-apikey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
