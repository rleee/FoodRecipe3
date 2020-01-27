package com.drdlee.foodrecipe3;

import android.os.Bundle;
import android.view.View;

public class RecipeListActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_list);

		findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mProgressBar.getVisibility() == View.VISIBLE) {
					showProgressbar(false);
				}
				else {
					showProgressbar(true);
				}
			}
		});
	}
}
