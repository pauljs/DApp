package com.example.pauljs.dapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * Created by pauljs on 11/3/2015.
 */
public class NotificationReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle mBundle = intent.getExtras();
        if (mBundle != null) {
            String mData = mBundle.getString("com.parse.Data");
            try {
                final JSONObject obj = new JSONObject(mData);
                Log.i("FULL PUSH NOTIFICATION", mData);
                mData = obj.getString("alert");
                Log.i("TEXT PUSH NOTIFICATION", mData);
                List<Notification> notifications = Notification.getSortedNotifications();
                if(notifications.size() >= 10) {
                    notifications.get(notifications.size() - 1).delete();
                }
                Notification new_notification = new Notification(mData, new Date());
                new_notification.save();
            } catch(JSONException e) {
                e.printStackTrace();
                Log.i("ERROR RECEIVING PUSH NOTIFICATION", mData);
            }
        } else {
            Log.i("NO RECENT PUSH NOTIFICATION", "");
        }
    }
}
