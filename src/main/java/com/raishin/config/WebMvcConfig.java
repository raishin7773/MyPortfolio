package com.raishin.config;

import com.raishin.interceptor.LogInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 設定
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * LocalValidatorFactoryBeanのsetValidationMessageSourceで
     * バリデーションメッセージをValidationMessages.propertiesからSpringの
     * MessageSource(messages.properties)に上書きする
     *
     * @return localValidatorFactoryBean
     */
    @Bean(name="validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }

    /**
     * ValidationのメッセージをUTF-8で管理します。
     * @return
     */
    @Bean(name = "messageSource")
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasename("classpath:ValidationMessages");
        bean.setDefaultEncoding("UTF-8");
        return bean;
    }

    /**
     * ログ用インターセプターの登録
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/portfolio/**");
    }
}