package rararoro.ryo.yourpartner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {

    public PowerConnectionReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("charging","NOOOO");
        if(Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            String messageb = "broadCast!!!";
            Toast.makeText(context, messageb, Toast.LENGTH_LONG);
        }
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
        if(isCharging){
            String message = "yes";
            Toast.makeText( context, "onReceive! " + message, Toast.LENGTH_LONG).show();
            Log.d("charging","YES");
            intent.setClass(context, MainActivity.class);
            context.startActivity(intent);
        }else{
        String message = "no";
        Toast.makeText( context, "onReceive! " + message, Toast.LENGTH_LONG).show();
            Log.d("charging", "YES");
    }
}
}
