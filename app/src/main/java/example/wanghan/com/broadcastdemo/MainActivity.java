package example.wanghan.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private  NetWorkChangeReceiver netWorkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter =new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver=new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);
    }

    class  NetWorkChangeReceiver extends BroadcastReceiver{
         @Override
         public void onReceive(Context context, Intent intent) {
             ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
             if ( networkInfo!=null && networkInfo.isAvailable()){
                 Toast.makeText(getApplicationContext(),"网络可用",Toast.LENGTH_SHORT).show();
             }else {
                 Toast.makeText(getApplicationContext(),"网络不可用",Toast.LENGTH_SHORT).show();
             }

         }
     }

}
