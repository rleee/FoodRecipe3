package com.drdlee.foodrecipe3.responses;

import androidx.annotation.NonNull;

import com.drdlee.foodrecipe3.models.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeResponse {

	@SerializedName("recipe")
	// we will receive "recipe object" from API, so we will use that "recipe object" -
	@Expose() // to expose to our recipe model
	private Recipe recipe;

	public Recipe getRecipe() {
		return recipe;
	}

	@NonNull
	@Override
	public String toString() {
		return "RecipeResponse{" +
				"recipe{" + recipe +
				"}}";
	}
}
