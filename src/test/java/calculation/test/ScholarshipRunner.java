package calculation.test;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runner.notification.RunNotifier;

public class ScholarshipRunner extends BlockJUnit4ClassRunner {
    private ScholarshipRunListener runListener;
    public ScholarshipRunner(Class<ScholarshipRunListener> clazz)
            throws InitializationError {
        super(clazz);
        runListener = new ScholarshipRunListener();
    }
    public void run(RunNotifier notifier) {
        notifier.addListener(runListener);
        super.run(notifier);
    }
}