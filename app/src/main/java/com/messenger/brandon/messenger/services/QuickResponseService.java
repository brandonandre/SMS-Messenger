package com.messenger.brandon.messenger.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class QuickResponseService extends Service {
    public QuickResponseService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
