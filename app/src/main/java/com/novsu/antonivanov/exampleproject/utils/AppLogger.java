package com.novsu.antonivanov.exampleproject.utils;

import android.util.Log;

/**
 * Date creation: 31.03.2016.
 */
public class AppLogger {
    public static String TAG = "ExampleProject";

    public static void log(String text) {

        String time = "" + System.currentTimeMillis();
        Log.d(TAG, time + " " + text);
    }
}
