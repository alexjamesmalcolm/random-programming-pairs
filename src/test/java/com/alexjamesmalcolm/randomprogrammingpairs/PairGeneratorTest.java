package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class PairGeneratorTest {
	
	private Collection<String> classmates;

	@Before
	public void setup() {
		classmates = new ArrayList<String>();
//		classmates.add("Alex Richards");
//		classmates.add("Jacob");
	}
	
	@Test
	public void shouldReturnCollectionOfPairs() {
		PairGenerator underTest = new PairGenerator(classmates);
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs.isEmpty(), is(false));
	}
	
	@Test
	public void shouldReturnAlexAndRyanPair() {
		classmates.add("Alex Malcolm");
		classmates.add("Ryan");
		PairGenerator underTest = new PairGenerator(classmates);
		Collection<String> pair = new ArrayList<>();
		pair.add("Alex Malcolm");
		pair.add("Ryan");
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs, containsInAnyOrder(pair));
	}
}
