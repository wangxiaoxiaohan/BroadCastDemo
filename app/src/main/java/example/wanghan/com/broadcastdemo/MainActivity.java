package example.wanghan.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private  NetWorkChangeReceiver netWorkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter =new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    class  NetWorkChangeReceiver extends BroadcastReceiver{
         @Override
         public void onReceive(Context context, Intent intent) {

         }
     }

}
