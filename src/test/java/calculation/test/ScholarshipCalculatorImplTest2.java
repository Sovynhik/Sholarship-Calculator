package calculation.test;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.NotSuchMarkException;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

public class ScholarshipCalculatorImplTest2 {
    private ScholarshipCalculatorImpl scholarshipCalculator;
    @Before // действия, выполняемые до выполнения теста
    public void initScholarshipCalculator() {
        scholarshipCalculator = new ScholarshipCalculatorImpl();//создаем объект
    }
    @After // действия, выполняемые после выполнения теста
    public void clearScholarshipCalculator() {
        scholarshipCalculator = null;//удаляем ссылку на объект
    }
    @Test //(expected = NotSuchMarkException.class)

    public void stepUpCoefficientForFiveTest() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(5);
        assertEquals("Coefficient for mark 5 is wrong:", expected, actual, 0.01);
    }
    @Test //(expected = NotSuchMarkException.class)

    public void stepUpCoefficientForThreeTest() throws NotSuchMarkException {
        double expected = 1;
        double actual = scholarshipCalculator.stepUpCoefficientCalculate(3);
        assertEquals("Coefficient for mark 3 is wrong:", expected, actual, 0.01);
    }
}

