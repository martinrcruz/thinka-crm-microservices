package cl.thinka.projectmicroservice.v1.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Project Microservice Documentation")
                        .description("Documentation of presentation layer -> Project Microservice")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Martin Rios")
                                .email("martinignacioriosc@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation"));
    }

}
