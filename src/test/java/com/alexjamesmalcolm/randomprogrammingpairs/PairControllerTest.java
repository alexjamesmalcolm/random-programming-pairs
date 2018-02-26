package com.alexjamesmalcolm.randomprogrammingpairs;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class PairControllerTest {
	
	@InjectMocks
	PairController underTest;
	
	@Mock
	Model model;
	
	@Mock
	PairGenerator generator;
	
	@Mock
	Collection<Collection<Person>> pairs;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGetPairs() {
		when(generator.getPairs()).thenReturn(pairs);
		underTest.selectPairs(model);
		verify(model).addAttribute("pairs", pairs);
	}
}