package calculation.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.NotSuchMarkException;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

import static org.junit.Assert.assertEquals;

@RunWith(ScholarshipRunner.class)
public class ScholarshipCalculatorImplTestWithListener {
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
    public void testStepUpCoefficientForFive() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(5);
        assertEquals("Коэффициент для балла 5 неверный", expected, actual, 0.01);
    }

    @Test(expected = NotSuchMarkException.class)
    public void testStepUpCoefficientForInvalidMark() throws NotSuchMarkException {
        scholarshipCalculator.stepUpCoefficientCalculate(6);
    }

    @Test(timeout = 1000)
    public void testScholarshipCalculate() {
        double basicScholarship = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP;
        double stepUpCoefficient = 1.3;
        double expected = basicScholarship * stepUpCoefficient;
        double actual = scholarshipCalculator.scholarshipCalculate(stepUpCoefficient);
        assertEquals("Стипендия для коэффициента 1.3 неверная", expected, actual, 0.01);
    }

    @Ignore("Тест не готов")
    @Test
    public void testNotImplemented() {
        // Заглушка для незавершенного теста
    }
}
