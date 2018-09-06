package com.gallelloit.spring.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.TrackCoach;

/**
 * Simple Spring application that creates a context from a XML file (beanLifeCycle-applicationContext.xml)
 * It gets the bean myTrackCoach, which implements the interface Coach
 * Coach interface uses internally the implementation HappyFortuneService
 * of FortuneService interface
 * 
 * In this example application, Spring beans lifecycle is shown. The track coach implementation
 * overrides the lifecycle methods ini-method and destroy-methods. They are configured in the
 * beanLifeCycle-applicationContext.xml file and executed,
 * as indicated in their names, right after the constructor and right before destroying
 * of the bean.
 * 
 * Some displays are shown for debug and testing purposes.
 * 
 * @author pgallello
 *
 */
public class Demo02LifeCycleXmlApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// Retrieve bean from Spring container
		Coach theCoach = context.getBean("myTrackCoach", TrackCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Close context
		context.close();
	}

}
