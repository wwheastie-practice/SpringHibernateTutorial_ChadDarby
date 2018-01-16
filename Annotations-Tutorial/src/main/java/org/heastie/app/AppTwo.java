package org.heastie.app;

import org.heastie.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTwo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);

        System.out.println("\nPoint to the same object: " + result);
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        context.close();
    }

}
