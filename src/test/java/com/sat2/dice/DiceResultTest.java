package com.sat2.dice;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DiceResultTest {

    private DiceResult diceResult;

    @Test
    public void testDiceResultCreation() {
        diceResult = new DiceResult(5, 20, Arrays.asList(3, 4, 2, 1, 5));
        assert diceResult.getDiceCount() == 5;
        assert diceResult.getDiceSides() == 20;
        assert diceResult.getTotal() == 15;
    }
    
}
