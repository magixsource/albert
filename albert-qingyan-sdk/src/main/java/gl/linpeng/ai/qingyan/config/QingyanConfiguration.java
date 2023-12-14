package gl.linpeng.ai.qingyan.config;

import gl.linpeng.ai.qingyan.QingyanClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Qingyan configuration
 */
@Configuration
public class QingyanConfiguration {

    @Bean
    public QingyanClient qingyanClient() {
        return new QingyanClient(qingyanConfig());
    }

    @Bean
    public QingyanProperties qingyanConfig() {
        return new QingyanProperties();
    }

}
