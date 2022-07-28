package cn.stuxx.workflow.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 包名: cn.stuxx.workflow.config
 * 类名: SwaggerConfig
 * 创建用户: 25789
 * 创建日期: 2022年07月28日 23:11
 * 项目名: workflow
 *
 * @author: 秦笑笑
 **/
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.stuxx.workflow")) //指定提供接口所在的基包
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 页面基础信息
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("秦笑笑", "https://www.stuxx.cn", "2578908933@qq.com");
        return new ApiInfo(
                "workflow",
                "工作流接口文档",
                "1.0",
                "https://www.stuxx.cn/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}