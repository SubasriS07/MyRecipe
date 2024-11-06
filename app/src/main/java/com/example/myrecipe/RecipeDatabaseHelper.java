package com.example.myrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_RECIPES = "recipes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_INGREDIENTS = "ingredients";
    private static final String COLUMN_STEPS = "steps";
    private static final String COLUMN_IMAGE = "image";

    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RECIPES_TABLE = "CREATE TABLE " + TABLE_RECIPES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_INGREDIENTS + " TEXT,"
                + COLUMN_STEPS + " TEXT,"
                + COLUMN_IMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_RECIPES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }

    public void addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, recipe.getName());
        values.put(COLUMN_INGREDIENTS, recipe.getIngredients());
        values.put(COLUMN_STEPS, recipe.getSteps());
        values.put(COLUMN_IMAGE, recipe.getImageResource());

        db.insert(TABLE_RECIPES, null, values);
        db.close();
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_RECIPES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe(
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INGREDIENTS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STEPS)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE))
                );
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recipeList;
    }
}

