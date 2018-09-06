package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.CricketCoach;

/**
 * Simple Spring application that creates a context from a XML file (applicationContext.xml)
 * It gets the bean myCricketCoach, which implements the interface Coach
 * 
 * The values of the plain private properties in CricketCoach implementation are fetch from sports.properties
 * This configuration is specified also in the applicationContext.xml:
 * 
 * - First tell Spring a placeholder property: <context:property-placeholder location="classpath:sport.properties"/>
 * - Then, in the bean definition, define the values of the properties using the values in the file:
 * 
 * 		- <property name="emailAddress" value="${foo.email}"></property>
 *   	- <property name="team" value="${foo.team}"></property>
 * 
 * This coach implementation uses internally the implementation RandomFortuneService of interface FortuneService
 * 
 * @author pgallello
 *
 */
public class Demo01BasicSpringXmlApp {

	public static void main(String[] args) {
		
		// Load the Spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

 		// Retrieve baseball coach object
		
		/*
		 * Java basics: if no implementation specific methods where used in this main program, it wouldn't be
		 * necessary to define the object with the implementation name. The next commented line shows how could
		 * be done:
		 * 
		 * Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);
		 * 
		 */
		
		/*
		 * As long as implementation specific methods are used (getEmailAddress() and getTeam()), the object need to be created with the
		 * implementation name.
		 */
		CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call methods on the bean
		System.out.println(">> Main. Daily workout: " + theCricketCoach.getDailyWorkout());
		System.out.println(">> Main. Daily fortune: " + theCricketCoach.getDailyFortune());
		
		System.out.println(">> Main. Coach email address: " + theCricketCoach.getEmailAddress());
		System.out.println(">> Main. Coach team:" + theCricketCoach.getTeam());

		
		// Close the context
		context.close();
		
	}

}