package com.sat2.dice;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DiceRoller {

  private Random random = new Random();

  public DiceResult roll(final int numberOfDice, final int sidesPerDie) {
    List<Integer> diceResults = new LinkedList<>();
    for (int i = 0; i < numberOfDice; i++) {
      diceResults.add(roledice(sidesPerDie));
    }
    return new DiceResult(numberOfDice, sidesPerDie, diceResults);
  }

  private int roledice(final int sidesPerDie) {
    int randomValue = random.nextInt(sidesPerDie) + 1;
    log.info("Rolled a {} on a d{}", randomValue, sidesPerDie);
    return randomValue;
  }
}