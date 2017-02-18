package org.greatworksinc.newsimon;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class DiceRoller {
  
  private final Random random;

  @VisibleForTesting DiceRoller(Random random) {
    this.random = random;
  }

  public DiceRoller() {
    this(new Random());
  }

  public static void main(String[] args) {
    DiceRoller diceRoller = new DiceRoller();
    int sum = 0;
    for (int i = 0; i < 7; i++) {
      if ((diceRoller.rollFiveSidedDice() + diceRoller.rollFiveSidedDice()) % 2 == 0) {
        sum++;
      }
    }
    System.out.println(sum);
  }

  private int rollFiveSidedDice() {
    return random.nextInt(5) + 1;
  }
}
