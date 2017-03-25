package org.greatworksinc.palindrome;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * This class will, when given a string, check to see if any potential anagram
 * of the string would be a palindrome.
 * 
 * @author ninja
 *
 */
public class Palindrome {
  public static boolean isPotentialyPalindrome(String input) {
    Map<Character, Integer> letters = Maps.newHashMap();
    for (char c : input.toCharArray()) {
      if (letters.get(c) == null) {
        letters.put(c, 1);
      } else {
        letters.put(c, letters.get(c) + 1);
      }
    }
    for (int i : letters.values()) {
      if (i % 2 == 1) {
        return false;
      }
    }
    return true;
  }
}
