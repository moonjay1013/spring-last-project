package com.dlu.config;

import com.dlu.component.LocalResolver;
import com.dlu.component.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 区域解释器 和 登陆拦截器 加入服务
 * @author moonjay
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final Logger log = LoggerFactory.getLogger(MvcConfig.class);

    // 将自定义的区域信息解析器以组件的形式添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new LocalResolver();
    }

    // 将自定义的拦截器注册到容器中。
    // 拦截所有请求，包括静态资源文件
    // 放行登录页，登陆操作，静态资源
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("注册拦截器");
//        可以用SpringSecurity高效赋权
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login","/result", "/css/**", "/images/**", "/js/**", "/fonts/**");
    }
}
