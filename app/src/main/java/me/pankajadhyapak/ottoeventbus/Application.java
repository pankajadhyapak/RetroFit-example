package me.pankajadhyapak.ottoeventbus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by PA035636 on 8/10/2015.
 */
public class Application extends android.app.Application {
    private static Bus mEventBus;

    public static Bus getEventBus() {
        return mEventBus;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mEventBus = new Bus(ThreadEnforcer.ANY);
    }
}
