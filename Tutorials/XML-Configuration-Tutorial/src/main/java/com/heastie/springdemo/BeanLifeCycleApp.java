package com.heastie.springdemo;

import com.heastie.coaches.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        TrackCoach theCoach = context.getBean("myCoach", TrackCoach.class);

        System.out.println(theCoach.getDailyWorkout());

        context.close();
    }

}
