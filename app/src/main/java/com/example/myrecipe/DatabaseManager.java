package com.example.myrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long addUser(String name, String email, int age, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_AGE, age);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);

        return database.insert(DatabaseHelper.TABLE_USERS, null, values);
    }

    public void close() {
        database.close();
    }
}
