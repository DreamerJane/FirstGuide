package com.example.firstguide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends Activity implements Runnable {

	/* 
	 * 欢迎界面activity，作为APP启动时默认显示的界面，每次启动APP都会显示
	 */
	
	private boolean isFirstUse;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		//启动一个延时线程
		new Thread(this).start();
		
	}

	@Override
	public void run() {
		try {
			//延时2秒
			Thread.sleep(2000);
			
			//获取SharedPreferences对象
			SharedPreferences preferences = getSharedPreferences("isFirstUse",MODE_PRIVATE);
			
			//取出文件中布尔型变量，如果不存在则将传入方法中默认值true
			isFirstUse = preferences.getBoolean("isFirstUse", true);
			
			//如果第一次启动APP，就跳转GuideActivity，否则直接跳转MainActivity
			if(isFirstUse) {
				startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
			}else {
				startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
			}
			//结束当前界面
			finish();
			
			//通过preferences的edit（）方法获取SharedPreferences.Editor对象
			Editor editor = preferences.edit();
			//向SharedPreferences.Editor对象中添加数据
			editor.putBoolean("isFirstUse", false);
			//提交数据，完成数据存储
			editor.commit();
			
		} catch (InterruptedException e) {
			//捕获中断异常
			e.printStackTrace();
		}
	}

}
