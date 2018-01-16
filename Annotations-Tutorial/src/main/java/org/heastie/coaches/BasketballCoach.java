package org.heastie.coaches;

import org.heastie.fortunes.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${will.email}")
    private String email;

    @Value("${will.team}")
    private String team;

    public String getDailyWorkout() {
        return "Shoot 50 3-Pointers";
    }

    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    @Autowired
    @Qualifier("randomFortuneService")
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void displayInformation() {
        System.out.println(email);
        System.out.println(team);
    }
}
