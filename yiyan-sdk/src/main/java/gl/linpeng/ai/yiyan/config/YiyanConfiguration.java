package gl.linpeng.ai.yiyan.config;

import gl.linpeng.ai.yiyan.YiyanClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Yiyan configuration
 */
@Configuration
public class YiyanConfiguration {

    @Bean
    public YiyanClient yiyanClient() {
        return new YiyanClient();
    }

    @Bean
    public YiyanProperties yiyanConfig() {
        return new YiyanProperties();
    }

}
