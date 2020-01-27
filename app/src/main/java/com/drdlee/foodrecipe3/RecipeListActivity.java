package com.drdlee.foodrecipe3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.drdlee.foodrecipe3.models.Recipe;
import com.drdlee.foodrecipe3.request.RecipeApi;
import com.drdlee.foodrecipe3.request.ServiceGenerator;
import com.drdlee.foodrecipe3.responses.RecipeSearchResponse;
import com.drdlee.foodrecipe3.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_list);

		findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),"check logcat", Toast.LENGTH_LONG).show();
				testRetrofitSearchRecipe();
			}
		});
	}

	private void testRetrofitSearchRecipe() {
		RecipeApi recipeAPI = ServiceGenerator.getRecipeApi();

		Call<RecipeSearchResponse> searchRecipes = recipeAPI.searchRecipe(
				Constants.API_KEY, "chicken breast", "1"
		);

		searchRecipes.enqueue(new Callback<RecipeSearchResponse>() {
			@Override
			public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
				Log.d("RecipeListActivity", "onResponse: " + response.toString());
				// ON LOGCAT: 2020-01-27 14:29:52.541 2916-2916/com.drdlee.foodrecipe3 D/RecipeListActivity: onResponse: Response{protocol=http/1.1, code=200, message=OK, url=https://recipesapi.herokuapp.com/api/search?key=&q=chicken%20breast&page=1}

				if (response.code() == 200) {
					Log.d("RecipeListActivity", "onResponse: body: " + response.body().toString());
					// ON LOGCAT: 2020-01-27 14:29:52.543 2916-2916/com.drdlee.foodrecipe3 D/RecipeListActivity: onResponse: body: RecipeSearchResponse{count=6,
					// recipes=[
					// Recipe{title='Spinach Stuffed Chicken Breast', recipe_id='30372', image_url='https://res.cloudinary.com/dk4ocuiwa/image/upload/v1575163942/RecipesApi/988509965f.jpg', social_rank=99.9999, ingredients=null, publisher='All Recipes', source_url='http://allrecipes.com/Recipe/Spinach-Stuffed-Chicken-Breast/Detail.aspx'},
					// ...]}

					List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
					for (Recipe recipe : recipes) {
						Log.d("RecipeListActivity", "onResponse: recipe title: " + recipe.getTitle());
						// ON LOGCAT: 2020-01-27 14:29:52.543 2916-2916/com.drdlee.foodrecipe3 D/RecipeListActivity: onResponse: recipe title: Spinach Stuffed Chicken Breast
						// and loop for all recipe title
					}
				}
			}

			@Override
			public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {

			}
		});
	}
}
