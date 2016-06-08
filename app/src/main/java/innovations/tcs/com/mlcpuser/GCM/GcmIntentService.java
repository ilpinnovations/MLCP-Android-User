package innovations.tcs.com.mlcpuser.GCM;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.gcm.GcmListenerService;

import innovations.tcs.com.mlcpuser.Activities.MainActivity;
import innovations.tcs.com.mlcpuser.R;

public class GcmIntentService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {

        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent intent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);

        String message = data.getString("message");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.splashlogo)
                .setContentTitle("MLCP")
                .setContentText(message);
        mBuilder.setContentIntent(intent);
        mBuilder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificationManager.notify(1, mBuilder.build());
    }
}