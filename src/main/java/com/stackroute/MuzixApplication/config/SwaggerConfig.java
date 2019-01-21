package com.stackroute.MuzixApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket productApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.MuzixApplication"))
                .paths(regex("/api/v1.*"))
                .build();
    }

//    private ApiInfo metaInfo()
//    {
//        ApiInfo apiInfo=new ApiInfo("MuzixDB Swagger API",
//                                   "MuzixDB Swagger API for Stackroute",
//                                    "1.0",
//                                    "Terms of Services",
//                                    new Contact("Debmalya","www.stackroute.in","dl@gmail.com"),
//                                    "Apache License Version 2.0",
//                                    "https://www.apache.org/license.html");
//        return apiInfo;
//    }
}
