package com.alexjamesmalcolm.randomprogrammingpairs;

import java.util.ArrayList;
import java.util.Collection;

public class PairGenerator {

	private ArrayList<String> classmates;

	public PairGenerator(Collection<String> classmates) {
		this.classmates = (ArrayList<String>) classmates;
	}

	public Collection<Collection<String>> getPairs() {
		Collection<Collection<String>> pairs = new ArrayList<Collection<String>>();
		for (int i = 0; i < classmates.size(); i += 2) {
			Collection<String> pair = new ArrayList<>();
			pair.add(classmates.get(i));
			pair.add(classmates.get(i + 1));
			pairs.add(pair);
		}
		return pairs;
	}

}
