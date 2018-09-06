package com.gallelloit.spring.business;

import com.gallelloit.spring.service.FortuneService;

/**
 * Class with two plain properties (emailAddress and team) and a reference to FortuneService
 * The implementation for FortuneService is defined in applicationContext.xml as the
 * randomFortuneService
 * 
 * Display messages are shown for debug purposes to see when each method is executed by
 * Spring Framework at bean creation time. 
 * 
 * @author pgallello
 *
 */
public class CricketCoach implements Coach {
	
	private String emailAddress;
	private String team;
	
	private FortuneService fortuneService;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	public CricketCoach() {
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice cricket for 1 hour.";
	}

	// Spring will generate the service that will bring up the fortune status
	public void setFortuneService(FortuneService fortuneService) {

		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return "Cricket fortune: " + fortuneService.getFortune();
	}

}