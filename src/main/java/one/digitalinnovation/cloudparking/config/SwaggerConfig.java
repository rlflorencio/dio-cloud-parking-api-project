package one.digitalinnovation.cloudparking.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;


public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.cloudparking"))
                .build()
                .apiInfo(metaData())
                .securityContexts(Arrays.asList(getSecurityContext()))
                .securitySchemes(Arrays.asList(basicAuthScheme()));
    }

    private SecurityScheme basicAuthScheme(){
        return new BasicAuth("basicAuth");
    }

    private SecurityContext getSecurityContext(){
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

    private SecurityReference basicAuthReference(){
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Parking REST API")
                .description("Spring Boot REST API for Parking")
                .version("1.0.0")
                .license("APache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0/")
                .build();
    }


}
