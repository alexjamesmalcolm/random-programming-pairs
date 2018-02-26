package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonTest {

	@Test
	public void shouldHaveNameAlex() {
		String name = "Alex";
		Person underTest = new Person(name);
		String returnedName = underTest.getName();
		assertThat(returnedName, is(name));
	}

	@Test
	public void shouldHaveNameRyan() {
		String name = "Ryan";
		Person underTest = new Person(name);
		String returnedName = underTest.getName();
		assertThat(returnedName, is(name));
	}
}
