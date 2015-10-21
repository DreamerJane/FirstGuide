package com.example.firstguide;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class GuideActivity extends Activity implements OnPageChangeListener {

	/*
	 * 引导界面activity，只在用户第一次启动时显示
	 */
	//定义ViewPager对象
	private ViewPager guideViewPager;
	//图片资源的数组
	private final int []pics = {R.drawable.a, 
								R.drawable.b,
								R.drawable.c,
								R.drawable.d};
	//存放图片的列表
	private List<View> picsList = new ArrayList<View>();
	//定义适配器对象
	private GuidePagerAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//将标题栏隐去
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		
		guideViewPager = (ViewPager) findViewById(R.id.guide_view_pager);
		//初始化ViewPager中的图片，存入列表
		initViews();
		
		//设置适配器
		adapter = new GuidePagerAdapter(picsList);
		guideViewPager.setAdapter(adapter);
		//监听ViewPager内容改变
		guideViewPager.setOnPageChangeListener(this);
		
	}


	private void initViews() {
		//将图片布局参数存入变量params
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		for(int i = 0; i < pics.length; i ++ ) {
			ImageView iv = new ImageView(this);
			//设置图片布局格式
			iv.setLayoutParams(params);
			//设置图片显示资源
			iv.setImageResource(pics[i]);
			//将图片加入列表，用于适配器使用
			picsList.add(iv);
		}
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int arg0) {
		//由于将ViewPager里的图片直接放入数组，
		//没有单独用xml文件设置布局，添加Button
		//设置Button监听点击事件再跳转MainActivity更人性化一些
		
		//当引导图片到达最后一张时，自动跳转MainActivity
		if(arg0 == pics.length - 1) {
			startActivity(new Intent(GuideActivity.this, MainActivity.class));
			finish();
		}
		
	}

}
