package org.heastie.app;

import org.heastie.coaches.BasketballCoach;
import org.heastie.coaches.Coach;
import org.heastie.coaches.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class AppOne {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("basketballCoach", Coach.class);
        BasketballCoach basketballCoach = context.getBean("basketballCoach", BasketballCoach.class);

//        System.out.println(theCoach.getDailyWorkout());
//        System.out.println(theCoach.getDailyFortune());
        basketballCoach.displayInformation();

        context.close();
    }

}
