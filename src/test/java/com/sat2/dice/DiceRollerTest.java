package com.sat2.dice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiceRollerTest {

    @Test
    void shouldRollBasicDice() {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll("3d6");
        
        assertNotNull(result, "Roll result should not be null");
        assertThat(result.getDiceCount()).isEqualTo(3);
        assertThat(result.getDiceSides()).isEqualTo(6);
        assertThat(result.getResults()).hasSize(3);
        assertThat(result.getResults())
            .allMatch(value -> value >= 1 && value <= 6);
    }

    @ParameterizedTest
    @CsvSource({
        "1d4,1,4",
        "2d6,2,6",
        "3d8,3,8",
        "1d10,1,10",
        "2d12,2,12",
        "1d20,1,20",
        "2d100,2,100"
    })
    void shouldRollDifferentDiceTypes(final String diceNotation, final int expectedCount, final int expectedSides) {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll(diceNotation);
        
        assertThat(result.getDiceCount()).isEqualTo(expectedCount);
        assertThat(result.getDiceSides()).isEqualTo(expectedSides);
        assertThat(result.getResults()).hasSize(expectedCount);
        assertThat(result.getResults())
            .allMatch(value -> value >= 1 && value <= expectedSides);
    }

    @Test
    void shouldCalculateTotalForMultipleDice() {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll("3d6");
        
        final int total = result.getTotal();
        final int sumOfResults = result.getResults().stream()
            .mapToInt(Integer::intValue)
            .sum();
            
        assertThat(total).isEqualTo(sumOfResults);
        assertThat(total).isBetween(3, 18);
    }
}