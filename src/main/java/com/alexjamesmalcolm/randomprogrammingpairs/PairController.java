package com.alexjamesmalcolm.randomprogrammingpairs;

import java.util.Collection;

import org.springframework.ui.Model;

public class PairController {
	
	private PairGenerator generator;

	public void selectPairs(Model model) {
		Collection<Collection<Person>> pairs = generator.getPairs();
		model.addAttribute("pairs", pairs);
	}

}
