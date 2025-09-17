package com.sat2.dice;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class DiceResultTest {

    private DiceResult diceResult;

    @Test
    public void testDiceResultCreation() {
        diceResult = new DiceResult(5, 20, Arrays.asList(3, 4, 2, 1, 5));
        assertThat(diceResult.getDiceCount()).isEqualTo(5);
        assertThat(diceResult.getDiceSides()).isEqualTo(20);
        assertThat(diceResult.getTotal()).isEqualTo(15);
        assertThat(diceResult.getResults()).containsExactly(3, 4, 2, 1, 5);
    }
    
    @Test
    public void testMultipleDiceWithHighValues() {
        diceResult = new DiceResult(3, 100, Arrays.asList(87, 92, 45));
        assertThat(diceResult.getDiceCount()).isEqualTo(3);
        assertThat(diceResult.getDiceSides()).isEqualTo(100);
        assertThat(diceResult.getTotal()).isEqualTo(224);
        assertThat(diceResult.getResults()).containsExactly(87, 92, 45);
    }
}
