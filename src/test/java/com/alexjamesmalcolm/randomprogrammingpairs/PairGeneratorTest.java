package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class PairGeneratorTest {
	
	private Collection<String> classmates;

	@Before
	public void setup() {
		classmates = new ArrayList<String>();
		classmates.add("Alex Malcolm");
		classmates.add("Ryan");
		classmates.add("Alex Richards");
		classmates.add("Jacob");
	}
	
	@Test
	public void shouldReturnCollectionOfPairs() {
		PairGenerator underTest = new PairGenerator(classmates);
		Collection<Collection<String>> pairs = underTest.getPairs();
		assertThat(pairs.isEmpty(), is(false));
	}
}
