package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.FootballCoach;

/**
 * Spring application that creates a context from a XML file (beanScope-applicationContext.xml)
 * It gets the bean myFootballCoach, which implements the interface Coach
 * This coach implementation uses internally the implementation HappyFortuneService of interface FortuneService
 * 
 * The resolved issue of this example is testing the two most used bean scopes from Spring: Singleton and Prototype
 * 
 * In the xml, two alternative versions of the bean definition are specified.
 * 
 * If the first one is uncommented, singleton approach will be used.
 * If the second one is uncommented, it will bye prototype.
 * 
 * - On the one side, Singleton will make Spring to create and return one instance of the bean no matter how many
 * times the bean is retrieved. You can see in the example how the memory location for the two retrieved objects
 * is the same.
 * - Whereas when Prototype strategy is defined, any time a new bean is requested to the container, a different
 * instance is created and retrieved. The test can be performed commenting the first myFootballCoach bean
 * in the beanScope-applicationContext.xml and commenting out the second one.
 * 
 * @author pgallello
 *
 */
public class Demo03BeanScopeXmlApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// Retrieve bean from Spring container
		FootballCoach oneCoach = context.getBean("myFootballCoach", FootballCoach.class);
		FootballCoach otherCoach = context.getBean("myFootballCoach", FootballCoach.class);
		
		// Check if they are the same beans
		boolean result = (oneCoach == otherCoach);
		
		// Print out the results
		System.out.println("\nPointing to the same object? " + result);

		System.out.println("\nMemory location for theCoach: " + oneCoach);
		System.out.println("\nMemory location for alphaCoach: " + otherCoach);
		
		// Set properties in the first object
		oneCoach.setEmailAddress("some-email@gmail.com");
		oneCoach.setTeam("Some team");
		
		// Get the properties from the second object
		System.out.println(">> Main. Second coach email: " + otherCoach.getEmailAddress());
		System.out.println(">> Main. Second coach team: " + otherCoach.getTeam());
		
		// Close context
		context.close();
		
	}

}