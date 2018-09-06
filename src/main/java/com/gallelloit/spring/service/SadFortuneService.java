package com.gallelloit.spring.service;

/**
 * Plain service simulation with just the implemented method getFortune returning
 * a fixed sad message.
 * @author pgallello
 *
 */
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You'll have a bad day today! Keep trying...";
	}

}