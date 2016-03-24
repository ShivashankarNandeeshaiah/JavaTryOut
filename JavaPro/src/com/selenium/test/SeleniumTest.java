package com.selenium.test;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		FirefoxDriver ff1= new FirefoxDriver();
		
		ff1.get("http://gmail.com");
		System.out.println("Yay ...It works ");
	}

}
