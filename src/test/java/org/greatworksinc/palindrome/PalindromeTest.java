package org.greatworksinc.palindrome;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class PalindromeTest {

  @Test (expected = IllegalArgumentException.class)
  public void isPotentialyPalindrome_null() {
    Palindrome.isPotentialyPalindrome(null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void isPotentialyPalindrome_empty() {
    Palindrome.isPotentialyPalindrome("");
  }
  
  @Test
  public void isPotentialyPalindrome_singleCharacter() {
    assertThat(Palindrome.isPotentialyPalindrome("a")).isTrue();
  }
  
  @Test
  public void isPotentialyPalindrome_abcbbc() {
    assertThat(Palindrome.isPotentialyPalindrome("abcbbc")).isFalse();
  }
  
  @Test
  public void isPotentialyPalindrome_abcdcba() {
    assertThat(Palindrome.isPotentialyPalindrome("abcdcba")).isTrue();
  }
  
  @Test
  public void isPotentialyPalindrome_abca() {
    assertThat(Palindrome.isPotentialyPalindrome("abca")).isFalse();
  }
  
  @Test
  public void isPotentialyPalindrome_abab() {
    assertThat(Palindrome.isPotentialyPalindrome("abab")).isTrue();
  }
  
  @Test
  public void isPotentialyPalindrome_abcbbaa() {
    assertThat(Palindrome.isPotentialyPalindrome("abcbbaa")).isFalse();
  }

  @Test
  public void isPotentialyPalindrome_abc() {
    assertThat(Palindrome.isPotentialyPalindrome("abc")).isFalse();
  }

}
