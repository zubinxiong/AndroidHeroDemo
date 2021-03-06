package me.ewriter.art_chapter5;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import me.ewriter.art_chapter5.utils.MyConstants;

public class DemoActivity_2 extends AppCompatActivity {

    private static final String TAG = "DemoActivity_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        getSupportActionBar().setTitle("DemoActivity2");

        Log.d(TAG, "onCreate");
        Toast.makeText(this, getIntent().getStringExtra("sid"),
                Toast.LENGTH_SHORT).show();
        initView();
    }

    private void initView() {

    }

    public void onButtonClick(View view) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.layout_simulated_notification);

        remoteViews.setTextViewText(R.id.msg, "msg from process: " + Process.myPid());
        remoteViews.setImageViewResource(R.id.icon, R.drawable.icon1);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, new Intent(this, DemoActivity_1.class), PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent openActivity2PendingIntent = PendingIntent.getActivity(
                this, 0, new Intent(this, DemoActivity_2.class), PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.item_holder, pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.open_activity2, openActivity2PendingIntent);
        Intent intent = new Intent(MyConstants.REMOTE_ACTION);
        intent.putExtra(MyConstants.EXTRA_REMOTE_VIEWS, remoteViews);
        sendBroadcast(intent);
    }
}
