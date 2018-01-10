package com.heastie.springdemo;

import com.heastie.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String args[]) {

        //Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Retrieve the bean from the spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        //Call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        //Close the context
        context.close();

    }

}
