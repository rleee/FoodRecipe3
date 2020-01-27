package com.drdlee.foodrecipe3.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class Recipe implements Parcelable {
	private String title;
	private String recipe_id;
	private String image_url;
	private float social_rank;
	private String[] ingredients;
	private String publisher;
	private String source_url;

	public Recipe(String title, String recipe_id, String image_url, float social_rank, String[] ingredients, String publisher, String source_url) {
		this.title = title;
		this.recipe_id = recipe_id;
		this.image_url = image_url;
		this.social_rank = social_rank;
		this.ingredients = ingredients;
		this.publisher = publisher;
		this.source_url = source_url;
	}

	public Recipe() {}

	protected Recipe(Parcel in) {
		title = in.readString();
		recipe_id = in.readString();
		image_url = in.readString();
		social_rank = in.readFloat();
		ingredients = in.createStringArray();
		publisher = in.readString();
		source_url = in.readString();
	}

	public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
		@Override
		public Recipe createFromParcel(Parcel in) {
			return new Recipe(in);
		}

		@Override
		public Recipe[] newArray(int size) {
			return new Recipe[size];
		}
	};

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public float getSocial_rank() {
		return social_rank;
	}

	public void setSocial_rank(float social_rank) {
		this.social_rank = social_rank;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSource_url() {
		return source_url;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	@Override
	public String toString() {
		return "Recipe{" +
				"title='" + title + '\'' +
				", recipe_id='" + recipe_id + '\'' +
				", image_url='" + image_url + '\'' +
				", social_rank=" + social_rank +
				", ingredients=" + Arrays.toString(ingredients) +
				", publisher='" + publisher + '\'' +
				", source_url='" + source_url + '\'' +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeString(recipe_id);
		dest.writeString(image_url);
		dest.writeFloat(social_rank);
		dest.writeStringArray(ingredients);
		dest.writeString(publisher);
		dest.writeString(source_url);
	}
}
