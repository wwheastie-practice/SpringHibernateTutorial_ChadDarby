package org.heastie.app;

import org.heastie.coaches.Coach;
import org.heastie.coaches.SwimCoach;
import org.heastie.configs.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppFour {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
    }
}
