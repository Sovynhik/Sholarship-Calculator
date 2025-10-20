package calculation.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.NotSuchMarkException;
import ru.rsreu.sovynhik.sholarshipcalculator.calculation.ScholarshipCalculatorImpl;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScholarshipCalculatorImplTestParameterized {
    private int averageMark;
    private double expectedStepUpCoefficient;
    private Class<? extends Exception> expectedException;

    // Конструктор для инициализации параметров
    public ScholarshipCalculatorImplTestParameterized(int averageMark, double expectedStepUpCoefficient, Class<? extends Exception> expectedException) {
        this.averageMark = averageMark;
        this.expectedStepUpCoefficient = expectedStepUpCoefficient;
        this.expectedException = expectedException;
    }

    // Набор тестовых данных
    @Parameters
    public static Collection<Object[]> stepUpCoefficientTableValues() {
        return Arrays.asList(new Object[][] {
                {3, 1.0, null},   // Ожидаем коэффициент 1.0 для балла 3
                {4, 1.3, null},   // Ожидаем коэффициент 1.3 для балла 4
                {5, 1.5, null},   // Ожидаем коэффициент 1.5 для балла 5
                {6, 0.0, NotSuchMarkException.class} // Ожидаем исключение для некорректного балла
        });
    }

    @Test
    public void testStepUpCoefficient() {
        ScholarshipCalculatorImpl calculator = new ScholarshipCalculatorImpl();
        if (expectedException != null) {
            try {
                calculator.stepUpCoefficientCalculate(averageMark);
                assertEquals("Ожидалось исключение " + expectedException.getName(), true, false);
            } catch (Exception e) {
                assertEquals("Неверный тип исключения", expectedException, e.getClass());
            }
        } else {
            try {
                double actual = calculator.stepUpCoefficientCalculate(averageMark);
                assertEquals("Коэффициент для балла " + averageMark + " неверный", expectedStepUpCoefficient, actual, 0.01);
            } catch (NotSuchMarkException e) {
                assertEquals("Неожиданное исключение для балла " + averageMark, true, false);
            }
        }
    }

    // Параметризованный тест для scholarshipCalculate
    @Test
    public void testScholarshipCalculate() {
        ScholarshipCalculatorImpl calculator = new ScholarshipCalculatorImpl();
        double basicScholarship = ScholarshipCalculatorImpl.BASIC_SCHOLARSHIP;
        if (expectedException == null) {
            double expected = basicScholarship * expectedStepUpCoefficient;
            double actual = calculator.scholarshipCalculate(expectedStepUpCoefficient);
            assertEquals("Стипендия для коэффициента " + expectedStepUpCoefficient + " неверная", expected, actual, 0.01);
        }
    }
}
