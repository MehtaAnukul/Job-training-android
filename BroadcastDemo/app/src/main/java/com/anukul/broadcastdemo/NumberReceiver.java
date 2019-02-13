package com.anukul.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class NumberReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            ContactDbHelper contactDbHelper = new ContactDbHelper(context);
            SQLiteDatabase sqLiteDatabase = contactDbHelper.getWritableDatabase();
            contactDbHelper.insertNumber(number,sqLiteDatabase);
            Toast.makeText(context, "Number Inserted.", Toast.LENGTH_SHORT).show();
            contactDbHelper.close();
        }
    }
}
