package com.example.myrecipe;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyRecipeDatabaseHelper extends SQLiteOpenHelper {

    // Database and table info
    private static final String DATABASE_NAME = "userrecipes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "recipes";

    // Table columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_RECIPE_NAME = "recipe_name";
    private static final String COLUMN_INGREDIENTS = "ingredients";
    private static final String COLUMN_STEPS = "steps";

    // Constructor
    public MyRecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_RECIPE_NAME + " TEXT, "
                + COLUMN_INGREDIENTS + " TEXT, "
                + COLUMN_STEPS + " TEXT" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to insert recipe
    public boolean insertRecipe(String email, String recipeName, String ingredients, String steps) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_RECIPE_NAME, recipeName);
        contentValues.put(COLUMN_INGREDIENTS, ingredients);
        contentValues.put(COLUMN_STEPS, steps);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // returns true if inserted successfully
    }

    // Method to retrieve all recipes
    public Cursor getAllRecipes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}


