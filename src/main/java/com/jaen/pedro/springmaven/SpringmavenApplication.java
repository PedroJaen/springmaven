package com.jaen.pedro.springmaven;

import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmavenApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringmavenApplication.class, args);

		// System.out.println("Hola mundo!");

		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());

		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
	}

}
