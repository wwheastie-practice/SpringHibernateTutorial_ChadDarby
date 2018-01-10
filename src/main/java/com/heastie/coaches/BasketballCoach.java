package com.heastie.coaches;

import com.heastie.fortunes.FortuneService;

public class BasketballCoach implements Coach {

    private FortuneService fortuneService;

    public BasketballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Shoot 100 3-Pointers";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
