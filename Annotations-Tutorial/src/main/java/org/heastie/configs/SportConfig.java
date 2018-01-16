package org.heastie.configs;

import org.heastie.coaches.Coach;
import org.heastie.coaches.SwimCoach;
import org.heastie.fortunes.FortuneService;
import org.heastie.fortunes.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
public class SportConfig {

    //Define bean for SadFortuneService
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    //Define bean for swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        return  new SwimCoach(sadFortuneService());
    }
}
