package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PairGeneratorTest {

	private ArrayList<Person> classmates;
	private Person deci = new Person("Alex Richards");
	private Person ryan = new Person("Ryan");
	private Person alex = new Person("Alex Malcolm");
	private Person jacob = new Person("Jacob");

	@Before
	public void setup() {
		classmates = new ArrayList<Person>();
	}

	@Test
	public void shouldReturnCollectionOfPairs() {
		classmates.add(deci);
		classmates.add(jacob);
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<Person>> pairs = underTest.getPairs();
		assertThat(pairs.isEmpty(), is(false));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnAlexAndRyanPair() {
		classmates.add(alex);
		classmates.add(ryan);
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Person> pair = new ArrayList<>();
		pair.add(alex);
		pair.add(ryan);
		Collection<Collection<Person>> pairs = underTest.getPairs();
		assertThat(pairs, containsInAnyOrder(pair));
	}

	@Test
	public void shouldBeHalfTheLengthOfTheNumberOfClassmates() {
		classmates.add(deci);
		classmates.add(jacob);
		classmates.add(alex);
		classmates.add(ryan);
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<Person>> pairs = underTest.getPairs();
		assertThat(pairs.size(), is(2));
	}

	@Test
	public void shouldHaveTheStooges() {
		classmates.add(deci);
		classmates.add(jacob);
		classmates.add(alex);
		classmates.add(ryan);
		classmates.add(new Person("Susan"));
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<Person>> pairs = underTest.getPairs();
		assertThat(pairs.size(), is(2));
	}

	@Test
	public void shouldHaveRandomOrder() {
		int count = 0;
		int iterations = 1000;
		classmates.add(deci);
		classmates.add(jacob);
		classmates.add(alex);
		classmates.add(ryan);
		for (int i = 0; i < iterations; i++) {
			PairGenerator underTest = new PairGenerator(classmates, true);
			Collection<Collection<Person>> pairs = underTest.getPairs();
			Collection<Person> pair = new ArrayList<>();
			pair.add(deci);
			pair.add(jacob);
			if (pairs.contains(pair)) {
				count++;
			}
		}
		assertThat(count, is(lessThan(iterations)));
		assertThat(count, is(greaterThan(0)));
	}
}
