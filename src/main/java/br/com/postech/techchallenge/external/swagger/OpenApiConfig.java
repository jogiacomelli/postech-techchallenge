package br.com.postech.techchallenge.external.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Pós Tech - Techchallenge ")
                        .description("Sistema Lanchonete")
                        .version("2.0"));
    }
}