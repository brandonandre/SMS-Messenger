package com.messenger.brandon.messenger.functionality;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.messenger.brandon.messenger.data.TextMessage;

/**
 * Created by brandonandre on 2017-03-30.
 */

public class DatabaseManagement extends SQLiteOpenHelper {

    public DatabaseManagement(Context context) {
        super(context, "messages.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createMessagesTable = "CREATE TABLE `messages` " + "("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`number` VARCHAR, "
                + "`text` VARCHAR, "
                + "`created` DATETIME, "
                + "`direction` CHAR(1), "
                + "`status` CHAR(1), "
                + "`serverId` INTEGER "
                + ") ";
        db.execSQL(createMessagesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table messages");
        onCreate(db);
    }

    public void addMessage(TextMessage msg){
        final SQLiteDatabase writableDatabase = getWritableDatabase();
        final ContentValues values = new ContentValues();

        values.put("number", msg.number);
        values.put("text", msg.message);
        values.put("created", msg.timestamp.toString());
        values.put("direction", "" + msg.direction);
        values.put("status", "" + msg.status);
        values.put("serverId", msg.serverId);

        msg.id = writableDatabase.insertOrThrow("messages", null, values);
    }

    //todo: get all messages for a conversation method.

}
