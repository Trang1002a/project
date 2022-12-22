package com.example.project.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafView;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan
public class SpringWebConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    public SpringWebConfig() {
        super();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bower_components/**").addResourceLocations("/WEB-INF/static/bower_components/");
        registry.addResourceHandler("/dist/**").addResourceLocations("/WEB-INF/static/dist/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/WEB-INF/static/plugins/");
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".jsp");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        Set<IDialect> additionalDialects = new HashSet<>();
        additionalDialects.add(new SpringSecurityDialect());
        templateEngine.setAdditionalDialects(additionalDialects);
        return templateEngine;
    }
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
    @Bean(name="content-part")
    @Scope("prototype")
    public ThymeleafView someViewBean() {
        ThymeleafView view = new ThymeleafView("index"); // templateName = 'index'
        view.setMarkupSelector("content");
        return view;
    }
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5*1024*1024);
        return resolver;
    }
}
