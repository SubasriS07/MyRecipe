package com.example.myrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeAdapter extends BaseAdapter {

    private Context context;
    private final String[] recipeNames;
    private final int[] recipeImages;

    public RecipeAdapter(Context context, String[] recipeNames, int[] recipeImages) {
        this.context = context;
        this.recipeNames = recipeNames;
        this.recipeImages = recipeImages;
    }

    @Override
    public int getCount() {
        return recipeNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        TextView recipeName = convertView.findViewById(R.id.recipe_name);
        ImageView recipeImage = convertView.findViewById(R.id.recipe_image);

        recipeName.setText(recipeNames[position]);
        recipeImage.setImageResource(recipeImages[position]);

        return convertView;
    }
}
