package com.app;

public class Exit {

	public static void exit() throws InterruptedException {
		
		System.out.println("Exiting System");
		int i = 5;
		while (i!=0) {
			System.out.println(".");
			Thread.sleep(450);
			i--;
		}
		System.out.println();
		System.out.println("Thankyou for using Hotel Reservation System!!");
		
	}
}
