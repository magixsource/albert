package gl.linpeng.ai.qianwen.config;

import gl.linpeng.ai.qianwen.QianwenClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Qianwen configuration
 */
@Configuration
public class QianwenConfiguration {

    @Bean
    public QianwenClient qianwenClient() {
        return new QianwenClient(qianwenConfig());
    }

    @Bean
    public QianwenProperties qianwenConfig() {
        return new QianwenProperties();
    }

}
