package khaliliyoussef.builtitbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class JokeLoadingTest
{
    private Context mContext;

    @Before
    public void getContext()
    {
        mContext = InstrumentationRegistry.getContext();
    }
    @Test
    public void checkAsyncTaskResult() throws ExecutionException, InterruptedException {
        String result = String.valueOf(new EndpointsAsyncTask().execute(mContext));
        assertNotEquals(result.trim().length(),0);
        assertEquals(result, "What is the opposite of Ipad You Pad");
    }
}