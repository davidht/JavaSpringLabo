package com.javaspringlabo.monproject.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.javaspringlabo.monproject.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("JavaSpringLabo API", "API Description", "1.0", "http://localhost:8080/",
				new Contact("David Hernández Tejada", "https://www.linkedin.com/in/dhtejada/",
						"https://www.linkedin.com/in/dhtejada/"),
				"GNU General Public License V.3", "https://www.gnu.org/licenses/gpl-3.0.html", Collections.emptyList());
	}
}