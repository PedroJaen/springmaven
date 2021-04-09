package com.jaen.pedro.springmaven;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@SpringBootTest
public class GreeterTest {

	public GreeterTest() {
	}

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

}
