package org.heastie.coaches;

import org.heastie.fortunes.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${will.email}")
    private String email;

    @Value("${will.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm-up.";
    }

    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
