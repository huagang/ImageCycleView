package com.minking.imagecycleview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.minking.imagecycleview.ImageCycleView.ImageCycleViewListener;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ImageCycleActivity extends Activity {

	private ImageCycleView mAdView;

	private ArrayList<String> mImageUrl = null;

	private String[] imageUrls = {"http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg",
			"http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg",
			"http://srimg1.meimei22.com/pic/suren/2014-9-24/1/8740_11329820378.jpg",
			"http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad_cycle);
		mImageUrl = new ArrayList<String>();
		for(String str: imageUrls){
			mImageUrl.add(str);
		}
		mAdView = (ImageCycleView) findViewById(R.id.ad_view);
		mAdView.setImageResources(mImageUrl, mAdCycleViewListener);
	}

	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(int position, View imageView) {
			Toast.makeText(ImageCycleActivity.this, "position->"+position, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void displayImage(String imageURL, ImageView imageView) {
			ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		mAdView.startImageCycle();
	};

	@Override
	protected void onPause() {
		super.onPause();
		mAdView.pushImageCycle();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mAdView.pushImageCycle();
	}

}
