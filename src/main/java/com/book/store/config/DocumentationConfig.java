package com.book.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DocumentationConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/.*")).paths(Predicates.not(PathSelectors.regex("/error.*"))).build()
				.apiInfo(new ApiInfoBuilder().title("Book Store API - Swagger documentation")
						.description("A sample for book Store api").termsOfServiceUrl("http://www.bookstore.com")
						.license("Copyright").version("V1.0").build());
	}
}
