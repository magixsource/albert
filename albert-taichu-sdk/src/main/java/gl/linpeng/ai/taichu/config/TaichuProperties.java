package gl.linpeng.ai.taichu.config;


import org.springframework.beans.factory.annotation.Value;

/**
 * Taichu config
 */
public class TaichuProperties {

    @Value("${albert.taichu.apikey:mock-apikey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
