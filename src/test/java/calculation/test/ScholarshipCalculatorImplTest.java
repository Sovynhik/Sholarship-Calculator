package calculation.test;

import org.junit.Assert;
import org.junit.Test;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.IscholarshipCalculator;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

public class ScholarshipCalculatorImplTest {
    @Test
    public void testScholarshipCalculate() {
        IscholarshipCalculator scholarshipCalculator =
                new ScholarshipCalculatorImpl();
        double basicScholarship = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP;
        double stepUpCoefficient = 0.1;
        double expected = basicScholarship * stepUpCoefficient;
        double actual = scholarshipCalculator.scholarshipCalculate(stepUpCoefficient);
        // проверка на совпадение с погрешностью 0,01
        Assert.assertEquals("Тест прошел", expected, actual, 0.01);
        //Assert.assertEquals( "Тест   не      прошел, т.к.", expected, actual, 0.01);
    }
}