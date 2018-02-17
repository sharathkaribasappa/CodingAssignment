package sample.com.codingassignment;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.ShadowMap;

/**
 * Created by sharathkaribasappa on 17/02/18.
 */

public class CustomTestRunner extends RobolectricTestRunner {
    /**
     * Creates a runner to run {@code testClass}.
     *
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */
    public CustomTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected ShadowMap createShadowMap() {
        return super.createShadowMap()
                .newBuilder()
                .addShadowClass(ShadowVolleyRequest.class)
                .build();
    }
}
