package com.parcom.usercache;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User cache")
                .description("Кэш для пользователей")
                .license(null)
                .licenseUrl(null)
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("", "", "pleshakoff@gmail.com"))
                .build();
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(
                Collections.singletonList(new ParameterBuilder()
                        .name("X-Auth-Token")
                        .description("userSecurityResponseDto session token")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


}
