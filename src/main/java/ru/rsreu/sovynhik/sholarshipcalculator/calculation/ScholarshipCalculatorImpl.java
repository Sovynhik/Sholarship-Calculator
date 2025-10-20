package ru.rsreu.sovynhik.sholarshipcalculator.calculation;

public class ScholarshipCalculatorImpl implements IscholarshipCalculator
{
    public static final double BASIC_SCHOLARSHIP = 100;
    public double scholarshipCalculate(double stepUpCoefficient) {
        return BASIC_SCHOLARSHIP * stepUpCoefficient;
    }
    public double stepUpCoefficientCalculate(int averageMark) throws NotSuchMarkException {
        return switch (averageMark) {
            case 3 -> 1;
            case 4 -> 1.3;
            case 5 -> 1.5;
            default -> throw new NotSuchMarkException("There is no mark: " + averageMark);
        };
    }
}

