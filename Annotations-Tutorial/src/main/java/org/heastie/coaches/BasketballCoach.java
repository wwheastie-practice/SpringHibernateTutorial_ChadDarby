package org.heastie.coaches;

import org.heastie.fortunes.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

    private FortuneService fortuneService;

    public String getDailyWorkout() {
        return "Shoot 50 3-Pointers";
    }

    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    @Autowired
    @Qualifier("randomFortuneService")
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println("BasketballCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }
}
