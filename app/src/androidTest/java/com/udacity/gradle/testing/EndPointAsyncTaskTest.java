package com.udacity.gradle.testing;

import android.os.Looper;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.MainFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by KNIGHT RIDER on 6/28/2018.
 */

@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest {

    @Test
    public void testDoInBackground() throws Exception {
        Looper.prepare();

        MainFragment mainFragment = new MainFragment();
        mainFragment.testFlag = true;
        new EndpointAsyncTask().execute(mainFragment);

        Thread.sleep(1000);
        if(MainFragment.testIsReady){
            assertNotNull(MainFragment.loadedJoke);
        }
        Log.i("loadedJokeMsg", MainFragment.loadedJoke);


    }
}

