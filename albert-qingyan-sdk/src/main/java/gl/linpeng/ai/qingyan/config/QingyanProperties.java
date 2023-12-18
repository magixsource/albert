package gl.linpeng.ai.qingyan.config;


import org.springframework.beans.factory.annotation.Value;

/**
 * Qingyan config
 */
public class QingyanProperties {

    @Value("${albert.qingyan.apikey:mock-apikey}")
    private String apiKey;

    @Value("${albert.qingyan.apisecret:mock-apisecret}")
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
