//package com.prashanth.flight.configuration;
//
//import com.prashanth.preexecution.TraceIdInterceptor;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@AllArgsConstructor
//public class InterceptorConfig implements WebMvcConfigurer   {
//    TraceIdInterceptor traceIdInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(traceIdInterceptor);
//
//    }
//}
