package org.heastie.fortunes;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private final String FORTUNE_ONE = "You're going to crush them this game!";
    private final String FORTUNE_TWO = "A shot will not be missed today.";
    private final String FORTUNE_THREE = "Working hard will bring all of your desires";

    public String getDailyFortune() {
        return randomFortune();
    }

    private String randomFortune() {

        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;

        switch(randomNumber) {
            case 1 : return FORTUNE_ONE;
            case 2 : return FORTUNE_TWO;
            case 3 : return FORTUNE_THREE;
        }

        return "Could not retrieve a fortune.";
    }
}
