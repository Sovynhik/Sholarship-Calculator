package calculation.test;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ScholarshipRunListener extends RunListener {
    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Тест стартовал: " + description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Тест завершен: " + description.getDisplayName() + "\n----");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Тест провален с исключением: " + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Тест игнорирован: " + description.getDisplayName() + "\n----");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Результаты выполнения тестов:");
        System.out.println("Время выполнения: " + result.getRunTime() + " ms");
        System.out.println("Запущено тестов: " + result.getRunCount());
        System.out.println("Провалено тестов: " + result.getFailureCount());
        System.out.println("Игнорировано тестов: " + result.getIgnoreCount());
        System.out.println("Все тесты завершены успешно: " + result.wasSuccessful());
    }
}