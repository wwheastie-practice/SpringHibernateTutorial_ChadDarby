package com.heastie.coaches;

import com.heastie.fortunes.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TrackCoach() {

    }

    public String getDailyWorkout() {
        return "Run a hard 5K";
    }

    public String getDailyFortune() {
        return null;
    }
}
