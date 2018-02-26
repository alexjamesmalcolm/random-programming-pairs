package com.alexjamesmalcolm.randomprogrammingpairs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class PairGenerator {

	private ArrayList<Person> classmates = new ArrayList<>();

	public PairGenerator(ArrayList<Person> classmates, boolean isRandom) {
		if (isRandom) {
			Random rng = new Random();
			for(int i = 0; i < classmates.size(); i++) {
				Person classmate = classmates.get(i);
				boolean coinFlip = rng.nextBoolean();
				if(coinFlip) {
					this.classmates.add(0, classmate);
				} else {
					this.classmates.add(classmate);
				}
			}
		} else {
			this.classmates = (ArrayList<Person>) classmates;
		}
	}

	public Collection<Collection<Person>> getPairs() {
		Collection<Collection<Person>> pairs = new ArrayList<Collection<Person>>();
		for (int i = 0; i < classmates.size(); i += 2) {
			Collection<Person> pair = new ArrayList<>();
			pair.add(classmates.get(i));
			pair.add(classmates.get(i + 1));
			if (classmates.size() - i == 3) {
				pair.add(classmates.get(i + 2));
				i++;
			}
			pairs.add(pair);
		}
		return pairs;
	}

}
