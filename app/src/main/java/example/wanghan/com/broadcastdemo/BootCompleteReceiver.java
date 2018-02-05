package example.wanghan.com.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
       Toast.makeText(context,"没什么意思，就是想让你看到，你懂了吧 ",Toast.LENGTH_SHORT).show();

      if (intent.getAction().equals(ACTION)) {
          Intent MainIntent = new Intent(context, MainActivity.class);
          MainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          context.startActivity(MainIntent);
      }
        throw new UnsupportedOperationException("Not yet implemented");

    }
    
}