package expotek.com.prioritease.dailyReminder;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

public class SchedulerUtil {

    public static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context, DailyReminderService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        builder.setRequiresCharging(false);
        builder.setMinimumLatency(3600 * 1000); // wait at least
        builder.setOverrideDeadline(3600 * 4 * 1000); // maximum delay
        JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());
    }

}
