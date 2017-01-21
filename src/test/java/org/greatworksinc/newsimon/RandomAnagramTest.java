package org.greatworksinc.newsimon;


import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class RandomAnagramTest {
	
	private RandomAnagram anagram;
	
	@Before
	public void setUp() {
		anagram = new RandomAnagram(new Random(0));
	}

	@Test
	public void generateAnagram() {
		assertThat(anagram.generateAnagram("Simon")).isEqualTo("minoS");
	}
	
	@Test
	public void generateAnagram2() {
		assertThat(anagram.generateAnagram("ABCDE")).isEqualTo("CBEDA");
	}

}
