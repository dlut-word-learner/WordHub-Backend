/**
 * @ClassName SaTokenConfigure
 * @description: TODO
 * @author 11131
 * @date 2023年09月26日
 * @version: 1.0
 */
package com.demo.wordhub.Configs;

import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaTokenConfigure {
    // Sa-Token 整合 jwt (Stateless 无状态模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStateless();
    }
}

