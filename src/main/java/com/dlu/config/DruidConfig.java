package com.dlu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class DruidConfig implements WebMvcConfigurer {
    /**
     * 当向容器中添加了 Druid 数据源
     * 使用 @ConfigurationProperties 将配置文件中 spring.datasource 开头的配置与数据源中的属性进行绑定
     * @return
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //同时开启 sql 监控(stat) 和防火墙(wall)，中间用逗号隔开。
        //开启防火墙能够防御 SQL 注入攻击
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 开启 Druid 数据源内置监控页面,展示 Druid 的统计信息
     *  启动 Spring Boot，浏览器访问“http://localhost:port/druid”
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        //向容器中注入 StatViewServlet，并将其路径映射设置为 /druid/*
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(statViewServlet, "/druid/*");
        //配置监控页面访问的账号和密码（选配）
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        return servletRegistrationBean;
    }

    /**
     * 向容器中添加 WebStatFilter
     * 开启内置监控中的 Web-jdbc 关联监控的数据
     *
     * URI 监控和 Session 监控也都被开启
     * @return
     */
    @Bean
    public FilterRegistrationBean druidWebStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(webStatFilter);
        // 监控所有的访问
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        // 监控访问不包括以下路径
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
