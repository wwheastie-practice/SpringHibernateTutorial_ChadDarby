package org.heastie.app;

import org.heastie.coaches.Coach;
import org.heastie.coaches.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class AppOne {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        context.close();
    }

}
