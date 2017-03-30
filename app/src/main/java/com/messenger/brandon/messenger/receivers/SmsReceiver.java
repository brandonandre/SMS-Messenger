package com.messenger.brandon.messenger.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Brandon on 3/29/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        String strMessage = "";

        // Make sure the data is there!
        if ( extras != null )
        {
            Object[] smsextras = (Object[]) extras.get( "pdus" );

            if (smsextras != null) {
                for (Object smsextra : smsextras) {
                    // TODO impliment the newest createFromPdu Format for better support!
                    SmsMessage smsmsg = SmsMessage.createFromPdu((byte[]) smsextra);

                    // Get the message body from the server.
                    String strMsgBody = smsmsg.getMessageBody();

                    //Get the address from where it came from.
                    String strMsgSrc = smsmsg.getOriginatingAddress();

                    strMessage += "SMS from " + strMsgSrc + " : " + strMsgBody;

                    Log.i(TAG, strMessage);
                }
            } else {
                // TODO handle error, should not be reachable but never know anymore...
            }
        }
    }
}
