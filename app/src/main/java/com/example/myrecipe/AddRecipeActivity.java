package com.example.myrecipe;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddRecipeActivity extends AppCompatActivity {

    private EditText etEmail, etRecipeName, etIngredients, etSteps;
    private Button btnSave;
    private MyRecipeDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        // Initialize views
        etEmail = findViewById(R.id.etEmail);
        etRecipeName = findViewById(R.id.etRecipeName);
        etIngredients = findViewById(R.id.etIngredients);
        etSteps = findViewById(R.id.etSteps);
        btnSave = findViewById(R.id.btnSave);

        // Initialize database helper
        databaseHelper = new MyRecipeDatabaseHelper(this);

        // Save button click listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String recipeName = etRecipeName.getText().toString();
                String ingredients = etIngredients.getText().toString();
                String steps = etSteps.getText().toString();

                boolean isInserted = databaseHelper.insertRecipe(email, recipeName, ingredients, steps);

                if (isInserted) {
                    Toast.makeText(AddRecipeActivity.this, "Recipe saved successfully", Toast.LENGTH_SHORT).show();
                    finish(); // Close activity after saving
                } else {
                    Toast.makeText(AddRecipeActivity.this, "Failed to save recipe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
