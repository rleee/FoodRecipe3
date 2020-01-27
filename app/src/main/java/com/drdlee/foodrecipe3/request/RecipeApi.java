package com.drdlee.foodrecipe3.request;

import com.drdlee.foodrecipe3.responses.RecipeResponse;
import com.drdlee.foodrecipe3.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

	//SEARCH
	@GET("api/search")
	Call<RecipeSearchResponse> searchRecipe(
			@Query("key") String key,
			@Query("q") String category,
			@Query("page") String page
	);

	//GET RECIPE
	@GET("api/get")
	Call<RecipeResponse> getRecipe(
		@Query("key") String key,
		@Query("rId") String recipeId
	);
}
