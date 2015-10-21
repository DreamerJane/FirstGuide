package com.example.firstguide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends Activity implements Runnable {

	/* 
	 * ��ӭ����activity����ΪAPP����ʱĬ����ʾ�Ľ��棬ÿ������APP������ʾ
	 */
	
	private boolean isFirstUse;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		//����һ����ʱ�߳�
		new Thread(this).start();
		
	}

	@Override
	public void run() {
		try {
			//��ʱ2��
			Thread.sleep(2000);
			
			//��ȡSharedPreferences����
			SharedPreferences preferences = getSharedPreferences("isFirstUse",MODE_PRIVATE);
			
			//ȡ���ļ��в����ͱ���������������򽫴��뷽����Ĭ��ֵtrue
			isFirstUse = preferences.getBoolean("isFirstUse", true);
			
			//�����һ������APP������תGuideActivity������ֱ����תMainActivity
			if(isFirstUse) {
				startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
			}else {
				startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
			}
			//������ǰ����
			finish();
			
			//ͨ��preferences��edit����������ȡSharedPreferences.Editor����
			Editor editor = preferences.edit();
			//��SharedPreferences.Editor�������������
			editor.putBoolean("isFirstUse", false);
			//�ύ���ݣ�������ݴ洢
			editor.commit();
			
		} catch (InterruptedException e) {
			//�����ж��쳣
			e.printStackTrace();
		}
	}

}
