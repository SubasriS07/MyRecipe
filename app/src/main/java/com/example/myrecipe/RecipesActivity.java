package com.example.myrecipe;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class RecipesActivity extends AppCompatActivity {

    GridView gridView;
    FloatingActionButton addRecipeButton;
    int[] recipeImages = {R.drawable.fried_rice, R.drawable.masala_dosa, R.drawable.margherita_pizza}; // Add recipe images
    String[] recipeNames = {"Fried Rice", "Masala Dosa", "Margherita Pizza"};
    String[] recipeIngredients = {
            "Ingredients for Recipe 1",
            "1 cup dosa batter,2 potatoes,1 onion,2 green chilies,1/2 tsp mustard seeds,1/4 tsp turmeric powder, Salt, oil",
            "Ingredints\n"+"1 pizza dough (store-bought or homemade)\n" +
                    "1/2 cup tomato sauce (or crushed tomatoes)\n" +
                    "150g fresh mozzarella (sliced)\n" +
                    "Fresh basil leaves\n" +
                    "1 tbsp olive oil\n" +
                    "Salt\n"
    };
    String[] recipeSteps = {
            "Steps for Recipe 1",
            "1. Heat oil in a pan, add mustard seeds, and let them crackle.\n" +
                    "2. Add onions, green chilies, and turmeric powder. Sauté until onions turn golden.\n" +
                    "3. Add boiled potatoes, salt, and mix well. Cook for 2 minutes. Garnish with coriander and set aside.\n" +
                    "4. Heat a flat pan, pour a ladle of dosa batter, and spread in a thin circle.\n" +
                    "5. Drizzle oil around the edges, cook until crispy, and place the potato filling in the center.\n" +
                    "6. Fold the dosa and serve with coconut chutney and sambar.\n",
            "Steps:\n"+"1. Preheat your oven to the highest setting (around 250°C/480°F).\n" +
                    "2. Roll out the pizza dough on a floured surface.\n" +
                    "3. Spread the tomato sauce evenly on the dough, leaving a small border.\n" +
                    "4. Arrange mozzarella slices on top and drizzle with olive oil. Sprinkle with a pinch of salt.\n" +
                    "5. Bake the pizza for 10-12 minutes, or until the crust is golden and the cheese is bubbly.\n" +
                    "6. Remove from the oven and garnish with fresh basil leaves. Serve hot.\n"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // Initialize GridView and FloatingActionButton
        gridView = findViewById(R.id.gridView);
        addRecipeButton = findViewById(R.id.add_recipe_button);

        RecipeAdapter adapter = new RecipeAdapter(this, recipeNames, recipeImages);
        gridView.setAdapter(adapter);
        Toolbar toolbr = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbr);
        // Handle click on grid items
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RecipesActivity.this, RecipeDetailActivity.class);
                intent.putExtra("image", recipeImages[position]);
                intent.putExtra("name", recipeNames[position]);
                intent.putExtra("ingredients", recipeIngredients[position]);
                intent.putExtra("steps", recipeSteps[position]);
                startActivity(intent);
            }
        });

        // FloatingActionButton to add new recipe
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to AddRecipeActivity (You need to create this activity)
                Intent intent = new Intent(RecipesActivity.this, AddRecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    // Inflate the app bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_menu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.action_my_recipes) {
            // Navigate to MyRecipesActivity
            Intent myRecipesIntent = new Intent(RecipesActivity.this, MyRecipesActivity.class);
            startActivity(myRecipesIntent);
            return true;

        } else if (itemId == R.id.action_logout) {
            // Handle logout logic
            Intent logoutIntent = new Intent(RecipesActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
            finish(); // Close the current activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
