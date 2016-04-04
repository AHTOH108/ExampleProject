package com.novsu.antonivanov.exampleproject.TestNotification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.novsu.antonivanov.exampleproject.MainActivity;
import com.novsu.antonivanov.exampleproject.R;

import java.io.IOException;

public class NotificationActivity extends AppCompatActivity {

    private static final String fileName = "tlumru_sound";

    private TextView tv;
    private int k = 1;
    private AssetManager mAssetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        tv = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(R.id.button);
        if (btn != null)
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickButton();
                }
            });

        mAssetManager = getAssets();
    }

    private void onClickButton() {
        Context context = getApplicationContext();
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        /*AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл ",
                    Toast.LENGTH_SHORT).show();
        }*/


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Uri path = Uri.parse("android.resource://com.novsu.antonivanov.exampleproject/raw/" + fileName);


        //PendingIntent pendingIntent = stackBuilder.getPendingIntent(Constants.PUSH_NOTIFICATION_REQUEST + push.getId(), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_tlum_statusbar)
                .setLargeIcon(largeIcon)
                .setContentTitle(getString(R.string.app_name))
                .setTicker("Ticker notification !!!!")
                .setContentText("ContentText notification !!!!")
                .setAutoCancel(true)
                .setSound(path)
                .setDefaults(NotificationCompat.DEFAULT_LIGHTS | NotificationCompat.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent)
                .setStyle(null);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(k, notificationBuilder.build());

        tv.setText(String.valueOf(k));
        k++;
    }
}
