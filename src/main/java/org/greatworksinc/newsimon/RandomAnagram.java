package org.greatworksinc.newsimon;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class RandomAnagram {
	private final Random random;
	@VisibleForTesting RandomAnagram(Random random) {
		this.random = random;
	}
	public RandomAnagram() {
		this(new Random());
	}
	public String generateAnagram(String inputString) {
		ArrayList<Character> anagram = new ArrayList<Character>();
		for (char letter : inputString.toCharArray()) {
			anagram.add(random.nextInt(anagram.size()), letter);
		}
		StringBuilder sb = new StringBuilder();
		for (char letter : anagram) {
			sb.append(letter);
		}
		return sb.toString();
		
	}
}
