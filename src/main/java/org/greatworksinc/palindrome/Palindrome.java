package org.greatworksinc.palindrome;

import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * This class will, when given a string, check to see if any potential anagram
 * of the string would be a palindrome.
 * 
 * @param input
 *          a non-empty, non-null string
 * @author ninja
 *
 */
public class Palindrome {
  public static boolean isPotentialyPalindrome(String input) {
    if (Strings.isNullOrEmpty(input)) {
      throw new IllegalArgumentException("Input must not be a null or empty string.");
    }
    boolean isEven = input.length() % 2 == 0;
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
        if (!isEven) {
          isEven = true;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
