package com.drdlee.foodrecipe3;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class BaseActivity extends AppCompatActivity {
	// make this class abstract so this class can only extended, not instantiated

	public ProgressBar mProgressBar;

	@Override
	public void setContentView(int layoutResID) {

		ConstraintLayout baseActivityXml = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
		FrameLayout frameLayout = baseActivityXml.findViewById(R.id.activity_content);
		mProgressBar = baseActivityXml.findViewById(R.id.pregress_bar);

		getLayoutInflater().inflate(layoutResID, frameLayout, true);
		// so this will take which activity that extends BaseActivity and inflate it into FrameLayout and attach to it

		super.setContentView(baseActivityXml);
		// lastly make the baseActivity as the contentView
	}

	public void showProgressbar(boolean isVisible) {
		mProgressBar.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
	}
}
