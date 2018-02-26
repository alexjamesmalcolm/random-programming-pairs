package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class PairGeneratorTest {

	private ArrayList<String> classmates;

	@Before
	public void setup() {
		classmates = new ArrayList<String>();
		// classmates.add("Alex Richards");
		// classmates.add("Jacob");
	}

	@Test
	public void shouldReturnCollectionOfPairs() {
		classmates.add("Alex Richards");
		classmates.add("Jacob");
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs.isEmpty(), is(false));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnAlexAndRyanPair() {
		classmates.add("Alex Malcolm");
		classmates.add("Ryan");
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<String> pair = new ArrayList<>();
		pair.add("Alex Malcolm");
		pair.add("Ryan");
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs, containsInAnyOrder(pair));
	}

	@Test
	public void shouldBeHalfTheLengthOfTheNumberOfClassmates() {
		classmates.add("Alex Richards");
		classmates.add("Jacob");
		classmates.add("Alex Malcolm");
		classmates.add("Ryan");
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs.size(), is(2));
	}

	@Test
	public void shouldHaveTheStooges() {
		classmates.add("Alex Richards");
		classmates.add("Jacob");
		classmates.add("Alex Malcolm");
		classmates.add("Ryan");
		classmates.add("Susan");
		PairGenerator underTest = new PairGenerator(classmates, false);
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs.size(), is(2));
	}

	@Test
	public void shouldHaveRandomOrder() {
		int count = 0;
		int iterations = 100;
		for (int i = 0; i < iterations; i++) {
			classmates.add("Alex Richards");
			classmates.add("Jacob");
			classmates.add("Alex Malcolm");
			classmates.add("Ryan");
			PairGenerator underTest = new PairGenerator(classmates, true);
			Collection<Collection<String>> pairs = underTest.getPairs();
			Collection<String> pair = new ArrayList<>();
			pair.add("Alex Richards");
			pair.add("Jacob");
			if(pairs.contains(pair)) {
				count ++;
			}
		}
		assertThat(count, is(lessThan(iterations)));
		assertThat(count, is(greaterThan(0)));
	}
}
