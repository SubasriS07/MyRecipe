package com.example.myrecipe;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    ImageView recipeImageView;
    TextView recipeNameView, ingredientsView, stepsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        recipeImageView = findViewById(R.id.recipe_image);
        recipeNameView = findViewById(R.id.recipe_name);
        ingredientsView = findViewById(R.id.recipe_ingredients);
        stepsView = findViewById(R.id.recipe_steps);

        // Retrieve data from the intent
        int image = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String ingredients = getIntent().getStringExtra("ingredients");
        String steps = getIntent().getStringExtra("steps");

        // Set data to the views
        recipeImageView.setImageResource(image);
        recipeNameView.setText(name);
        ingredientsView.setText(ingredients);
        stepsView.setText(steps);
    }
}
