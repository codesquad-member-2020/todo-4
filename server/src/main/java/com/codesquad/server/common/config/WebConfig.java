package com.codesquad.server.common.config;

import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@CrossOrigin("*")
public class WebConfig implements WebMvcConfigurer {

//    @NonNull
//    private final JwtAuthInterceptor jwtAuthInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .maxAge(3600)
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.PATCH.name(),
                        HttpMethod.DELETE.name(),
                        HttpMethod.OPTIONS.name());
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> swaggerPathPatterns = new ArrayList<>();
//
//        swaggerPathPatterns.add("/");
//        swaggerPathPatterns.add("/swagger-ui.html");
//        swaggerPathPatterns.add("/swagger-resources/**");
//        swaggerPathPatterns.add("/error");
//        swaggerPathPatterns.add("/webjars/**");
//        swaggerPathPatterns.add("/csrf");
//
//        registry.addInterceptor(jwtAuthInterceptor)
//                .addPathPatterns("/*")
//                .excludePathPatterns("/columns")
//                .excludePathPatterns(swaggerPathPatterns);
//    }
}
