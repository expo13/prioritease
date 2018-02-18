package expotek.com.prioritease.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import expotek.com.prioritease.dailyReminder.SchedulerUtil;

public class BootupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SchedulerUtil.scheduleJob(context);
    }
}

