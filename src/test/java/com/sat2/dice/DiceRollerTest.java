package com.sat2.dice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiceRollerTest {

    @ParameterizedTest
    @CsvSource({
            "3,6",
            "1,4",
            "2,6",
            "3,8",
            "1,10",
            "2,12",
            "1,20",
            "2,100"
    })
    void shouldRollBasicDice(final int numberOfDice, final int sidesPerDie) {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll(numberOfDice, sidesPerDie);
        assertNotNull(result, "Roll result should not be null");
        assertThat(result.getDiceCount()).isEqualTo(numberOfDice);
        assertThat(result.getDiceSides()).isEqualTo(sidesPerDie);
        assertThat(result.getResults()).hasSize(numberOfDice);
        assertThat(result.getResults())
                .allMatch(value -> value >= 1 && value <= sidesPerDie);
    }

    @ParameterizedTest
    @CsvSource({
            "3,6",
            "1,4",
            "2,6",
            "3,8",
            "1,10",
            "2,12",
            "1,20",
            "2,100"
    })
    void shouldCalculateTotalForMultipleDice(final int numberOfDice, final int sidesPerDie) {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll(numberOfDice, sidesPerDie);
        final int total = result.getTotal();
        final int sumOfResults = result.getResults().stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertThat(total).isEqualTo(sumOfResults);
        assertThat(total).isBetween(numberOfDice, numberOfDice * sidesPerDie);
    }
}