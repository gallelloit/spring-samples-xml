package com.gallelloit.spring.business;

import com.gallelloit.spring.service.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	/**
	 * Empty constructor. In the original demo app, it won't be executed
	 */
	public TrackCoach() {
		System.out.println(">> Track Coach: Inside empty constructor");
	}
	
	/**
	 * Constructor with FortuneService parameter
	 * It will be called by Spring engine in the original demo app.
	 * As specified in the xml Spring configuration file, it is set as an instance of
	 * HappyFortuneService implementation of FortuneService interface
	 * 
	 * @param theFortuneService
	 */
	public TrackCoach(FortuneService theFortuneService) {
		System.out.println(">> Track Coach: Inside fortune constructor");
		fortuneService = theFortuneService; 
	}
	
	@Override
	public String getDailyWorkout() {
		return ">> Track coach: Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return ">> Track Fortune: " + fortuneService.getFortune();
	}
	
	// Init and destroy methods
	
	public void initMethod() {
		System.out.println(">> TrackCoach: inside init method");
	}

	public void destroyMethod() {
		System.out.println(">> TrackCoach: inside destroy method");
	}
	
}