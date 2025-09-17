package com.sat2.dice;

import lombok.Value;
import java.util.List;

@Value
public class DiceResult {
    int diceCount;
    int diceSides;
    List<Integer> results;
    int total;

    public DiceResult(int diceCount, int diceSides, List<Integer> results) {
        this.diceCount = diceCount;
        this.diceSides = diceSides;
        this.results = List.copyOf(results);
        this.total = results.stream()
                          .mapToInt(Integer::intValue)
                          .sum();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%dd%d:%n", diceCount, diceSides));
        
        results.forEach(result -> 
            sb.append(String.format("\t1d%d: %d%n", diceSides, result))
        );
        
        sb.append(String.format("total: %d", total));
        return sb.toString();
    }
}