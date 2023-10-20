package cn.dlut.conspirer.wordhub.Configs;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configure JWT plugin for Sa-Token (Stateless mode)
 *
 * @author OuOu
 * @version 1.0
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    /**
     * Sa-Token 整合JWT(stateless无状态模式，不需要Redis)
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStateless();
    }

    /**
     * 注册 Sa-Token 拦截器，打开注解式鉴权功能
     * @param registry to be added
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}

