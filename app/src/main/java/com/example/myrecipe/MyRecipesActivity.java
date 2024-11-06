package com.example.myrecipe;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyRecipesActivity extends AppCompatActivity {

    private ListView listView;
    private MyRecipeDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);

        listView = findViewById(R.id.listView);
        databaseHelper = new MyRecipeDatabaseHelper(this);

        loadRecipes();
    }

    // Method to load recipes from database
    private void loadRecipes() {
        Cursor cursor = databaseHelper.getAllRecipes();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No recipes found", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<String> recipeList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String recipeName = cursor.getString(cursor.getColumnIndex("recipe_name"));
            String ingredients = cursor.getString(cursor.getColumnIndex("ingredients"));
            String steps = cursor.getString(cursor.getColumnIndex("steps"));

            recipeList.add("Recipe: " + recipeName + "\nIngredients: " + ingredients + "\nSteps: " + steps);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeList);
        listView.setAdapter(adapter);
    }
}
