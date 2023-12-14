package gl.linpeng.ai.taichu.config;

import gl.linpeng.ai.taichu.TaichuClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Taichu configuration
 */
@Configuration
public class TaichuConfiguration {

    @Bean
    public TaichuClient taichuClient() {
        return new TaichuClient(taichuConfig());
    }

    @Bean
    public TaichuProperties taichuConfig() {
        return new TaichuProperties();
    }

}
