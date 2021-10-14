package com.ktx.ddep.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Scheduled(cron = "0/4 0 * * * *")
	private void why() {
		System.out.println("카페!");
		// TODO Auto-generated method stub
	}
	@Scheduled(cron = "1/4 0 * * * *")
	private void why1() {
		System.out.println("우회전!");
		// TODO Auto-generated method stub
	}
	@Scheduled(cron = "2/4 0 * * * *")
	private void why2() {
		System.out.println("좌회전!");
		// TODO Auto-generated method stub
	}
	@Scheduled(cron = "3/4 0 * * * *")
	private void why3() {
		System.out.println("도착!");
		// TODO Auto-generated method stub
	}

}
