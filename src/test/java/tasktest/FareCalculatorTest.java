package tasktest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rsreu.sovynhik.sholarshipcalculator.taskforexample.FareCalculator;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {
    private FareCalculator fareCalculator;
    private BiFunction<Double, Double, Double> economyFare;
    private BiFunction<Double, Double, Double> comfortFare;
    private BiFunction<Double, Double, Double> premiumFare;

    @BeforeEach
    public void setUp() {
        fareCalculator = new FareCalculator();
        economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
    }

    @Test
    public void testCalculateFareWithEconomyFare() {
        double distance = 10;
        double time = 15.0;
        double expectedCost = 1.0 * 10 + 0.5 * 15;
        double actualCost = fareCalculator.calculateFare(distance, time, economyFare);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    @Test
    public void testCalculateFareWithComfortFare() {
        double distance = 10;
        double time = 15.0;
        double expectedCost = 1.5 * 10 + 0.8 * 15;
        double actualCost = fareCalculator.calculateFare(distance, time, comfortFare);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    @Test
    public void testCalculateFareWithPremiumFare() {
        double distance = 10;
        double time = 15.0;
        double expectedCost = 2 * 10 + 1.5 * 15;
        Double actualCost = premiumFare.apply(distance, time);
        assertEquals(expectedCost, actualCost, 0.001);
    }
}
