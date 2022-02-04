package xyx.ruhshan.suburb.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${spring.application.name}") String title) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title(title)
                        .description(
                                "Ruhshan Ahmed, github.com/Ruhshan")
                        .version("0.0.1-SNAPSHOT"));
    }
}

