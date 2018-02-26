package com.alexjamesmalcolm.randomprogrammingpairs;

import java.util.ArrayList;
import java.util.Collection;

public class PairGenerator {

	private Collection<String> classmates;

	public PairGenerator(Collection<String> classmates) {
		this.classmates = classmates;
	}

	public Collection<Collection<String>> getPairs() {
		 Collection<Collection<String>> results = new ArrayList<Collection<String>>();
		 results.add(classmates);
		 return results;
	}

}
