package calculation.test;

import org.junit.runner.notification.RunListener;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(ScholarshipRunner.class)

public class ScholarshipRunListener extends RunListener {
    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("тест стартовал: " +
                description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("тест завершен: " +
                description.getDisplayName() + "\n----");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("тест провален с исключением: "
                + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("тест игнорирован: " +
                description.getDisplayName() + "\n----");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("результаты выполнения тестов:");
        System.out.println("время выполнения: (" + result.getRunTime()
                + ") millis");
        System.out.println("было запущено тестов: " +
                result.getRunCount());
        System.out.println("провалено тестов: " +
                result.getFailureCount());
        System.out.println("игнорировано тестов: " +
                result.getIgnoreCount());
        System.out.println("все тесты завершены успешно: "
                + result.wasSuccessful());
    }
}