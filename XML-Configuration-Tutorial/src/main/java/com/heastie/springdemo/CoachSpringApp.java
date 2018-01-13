package com.heastie.springdemo;

import com.heastie.coaches.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachSpringApp {
    public static void main(String args[]) {

        //Setup context file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Create new instance of coach by retrieving bean
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //Call methods on the bean created object
        System.out.println();
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println();
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println();
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println();
        System.out.println(cricketCoach.getTeam());
    }
}
