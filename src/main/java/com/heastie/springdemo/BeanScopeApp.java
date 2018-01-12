package com.heastie.springdemo;

import com.heastie.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
    public static void main(String args[]) {

        //Load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //Retrieve bean from the spring container
        Coach theCoach = context.getBean("myPrototypeCoach", Coach.class);
        Coach headCoach = context.getBean("myPrototypeCoach", Coach.class);

        //Check to see if they are same beans
        boolean result = (theCoach == headCoach);

        //Print out results
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for headCoach: " + headCoach);
    }
}
