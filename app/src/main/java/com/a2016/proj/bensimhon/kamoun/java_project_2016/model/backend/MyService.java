package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    final  String TAG = "myservice";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        // TODO: Return the communication channel to the service.
        return  null;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        Toast.makeText(this,"run service",Toast.LENGTH_LONG).show();

        Thread t = new Thread() {
            @Override
            public void run() {

                while (true)
                {
                    try {
                        Thread.sleep(5000);
                        Log.d(TAG,"thread run ..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(DBManagerFactory.getManager().isUpdate())
                    {
                        Log.d(TAG,"isUpdatet run ..");
                        Intent intent1 = new Intent("com.oshri.academy.myaction");
                       MyService.this.sendBroadcast(intent1);
                        //sendBroadcast(intent);
                    }

                }
            }
        };

        t.start();




        return START_STICKY;
    }
}
