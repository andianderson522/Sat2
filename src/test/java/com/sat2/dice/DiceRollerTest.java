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
        final DiceResult result = roller.roll(3, 6);
        
        assertNotNull(result, "Roll result should not be null");
        assertThat(result.getDiceCount()).isEqualTo(3);
        assertThat(result.getDiceSides()).isEqualTo(6);
        assertThat(result.getResults()).hasSize(3);
        assertThat(result.getResults())
            .allMatch(value -> value >= 1 && value <= 6);
    }

    @ParameterizedTest
    @CsvSource({
        "1,4",
        "2,6",
        "3,8",
        "1,10",
        "2,12",
        "1,20",
        "2,100"
    })
    void shouldRollDifferentDiceTypes(final short amount, final short sides) {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll(amount, sides);
        
        assertThat(result.getDiceCount()).isEqualTo(amount);
        assertThat(result.getDiceSides()).isEqualTo(sides);
        assertThat(result.getResults()).hasSize(amount);
        assertThat(result.getResults())
            .allMatch(value -> value >= 1 && value <= sides);
    }

    @Test
    void shouldCalculateTotalForMultipleDice() {
        final DiceRoller roller = new DiceRoller();
        final DiceResult result = roller.roll((short)3, (short)6);
        
        final int total = result.getTotal();
        final int sumOfResults = result.getResults().stream()
            .mapToInt(Integer::intValue)
            .sum();
            
        assertThat(total).isEqualTo(sumOfResults);
        assertThat(total).isBetween(3, 18);
    }
}