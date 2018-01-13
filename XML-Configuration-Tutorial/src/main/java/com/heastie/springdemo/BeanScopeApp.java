package com.heastie.springdemo;

import com.heastie.coaches.BasketballCoach;
import com.heastie.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.pkcs11.wrapper.CK_RSA_PKCS_OAEP_PARAMS;

public class BeanScopeApp {
    public static void main(String args[]) {

        //Load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //Retrieve bean from the spring container
        Coach theCoach = context.getBean("myBasketballCoach", Coach.class);
        Coach headCoach = context.getBean("myBasketballCoach", BasketballCoach.class);

        //Check to see if they are same beans
//        boolean result = (theCoach == headCoach);

        //Print out results
        System.out.println("\nPointing to the same object: " + theCoach.equals(headCoach));
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for headCoach: " + headCoach);
    }
}
