package com.heastie.coaches;

import com.heastie.fortunes.FortuneService;

public class BaseballCoach implements Coach {

    //Define a private field for the dependency
    private FortuneService fortuneService;

    //Define a constructor for dependency injection
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 30 minutes on practicing batting";
    }

    public String getDailyFortune() {
        //Use fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
