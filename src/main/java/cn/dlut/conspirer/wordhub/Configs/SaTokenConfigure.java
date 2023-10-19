package cn.dlut.conspirer.wordhub.Configs;

import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure JWT plugin for Sa-Token (Stateless mode)
 *
 * @author OuOu
 * @version 1.0
 */
@Configuration
public class SaTokenConfigure {
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStateless();
    }
}

