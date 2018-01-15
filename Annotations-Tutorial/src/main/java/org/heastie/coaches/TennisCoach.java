package org.heastie.coaches;

import org.heastie.fortunes.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
