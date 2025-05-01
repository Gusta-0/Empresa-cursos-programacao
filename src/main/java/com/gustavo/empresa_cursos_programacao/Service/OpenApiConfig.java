package com.gustavo.empresa_cursos_programacao.Service;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Cursos de Programação")
                        .description("Documentação da API para gerenciamento de cursos")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Gustavo Alves")
                                .email("gabs.principal.2005@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(List.of(new Server().url("http://localhost:8080")));
    }
}