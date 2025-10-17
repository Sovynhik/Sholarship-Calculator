package calculation.test;
import java.util.Arrays;

import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.NotSuchMarkException;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

@RunWith(Parameterized.class)

public class ScholarshipCalculatorImplTest4 {
    // объявление параметров в виде полей
    private int averageMark;
    private double stepUpCoefficient;
    // public-конструктор с параметрами для инициализации полей
    public ScholarshipCalculatorImplTest4(int averageMark, double
            stepUpCoefficient) {
        this.averageMark = averageMark;
        this.stepUpCoefficient = stepUpCoefficient;
    }

    // определение набора параметров в виде коллекции
    @Parameters public static Collection<Object[]>
    stepUpCoefficientTableValues() {
        return Arrays.asList(new Object[][] {
                { 3, 1.0 },
                { 4, 1.3 },
                { 5, 1.5 }
        });
    }

    @Test
    public void stepUpCoefficientTest() throws NotSuchMarkException {
        ScholarshipCalculatorImpl scholarshipCalculator =
                new ScholarshipCalculatorImpl();
        double expected = this.stepUpCoefficient;
        double actual =
                scholarshipCalculator.stepUpCoefficientCalculate(this.averageMark);
        assertEquals(expected, actual, 0.01);
    }
}

