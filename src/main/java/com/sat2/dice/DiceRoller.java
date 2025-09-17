package com.sat2.dice;

import java.util.Arrays;

public final class DiceRoller {

    public DiceResult roll(final int numberOfDice, final int sidesPerDie) {
      return new DiceResult(3, 6, Arrays.asList(1,2,3)); // Stub implementation 
    }
}