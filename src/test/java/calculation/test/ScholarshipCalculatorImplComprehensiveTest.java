package calculation.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.NotSuchMarkException;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@Suite.SuiteClasses({ScholarshipCalculatorImplTest.class, ScholarshipCalculatorImplTest2.class,
        ScholarshipCalculatorImplTestParameterized.class, ScholarshipCalculatorImplTestWithListener.class})
public class ScholarshipCalculatorImplComprehensiveTest {
    private ScholarshipCalculatorImpl scholarshipCalculator;

    @Before
    public void initScholarshipCalculator() {
        scholarshipCalculator = new ScholarshipCalculatorImpl();
    }

    @After
    public void clearScholarshipCalculator() {
        scholarshipCalculator = null;
    }

    @Test
    public void testScholarshipCalculateZeroCoefficient() {
        double stepUpCoefficient = 0.0;
        double expected = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP * stepUpCoefficient;
        double actual = scholarshipCalculator.scholarshipCalculate(stepUpCoefficient);
        assertEquals("Стипендия для нулевого коэффициента неверная", expected, actual, 0.01);
    }

    @Test
    public void testScholarshipCalculateNegativeCoefficient() {
        double stepUpCoefficient = -1.0;
        double expected = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP * stepUpCoefficient;
        double actual = scholarshipCalculator.scholarshipCalculate(stepUpCoefficient);
        assertEquals("Стипендия для отрицательного коэффициента неверная", expected, actual, 0.01);
    }

    @Test
    public void testStepUpCoefficientForFour() throws NotSuchMarkException {
        double expected = 1.3;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(4);
        assertEquals("Коэффициент для балла 4 неверный", expected, actual, 0.01);
    }
}
