package com.gallelloit.spring.service;

/**
 * Plain service simulation with just the implemented method getFortune returning
 * a fixed happy message.
 * @author pgallello
 *
 */
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		 return "Today is your lucky day!";
	}
	
}