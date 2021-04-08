package com.octo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    //    @Bean
//    public WebMvcConfigurer addCorsMappings(CorsRegistry registry) {
//        return  new WebMvcConfigurer() {
//           @Override
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping("/**")
//                        .allowedMethods("GET","POST","PUT","DELET","OPTION")
//                        .allowedHeaders("*")
//                        .allowedOrigins("http://localhost:4200");
//           }
//            };
//
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200").
                allowedMethods("GET","POST","PUT","DELET","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

    }
}
