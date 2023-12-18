package gl.linpeng.ai.yiyan.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Yiyan config
 */
public class YiyanProperties {
    @Value("${albert.yiyan.apikey:mock-apikey}")
    private String apiKey;
    @Value("${albert.yiyan.apisecret:mock-apisecret}")
    private String apiSecret;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }
}
