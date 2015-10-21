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
	 * ��������activity��ֻ���û���һ������ʱ��ʾ
	 */
	//����ViewPager����
	private ViewPager guideViewPager;
	//ͼƬ��Դ������
	private final int []pics = {R.drawable.a, 
								R.drawable.b,
								R.drawable.c,
								R.drawable.d};
	//���ͼƬ���б�
	private List<View> picsList = new ArrayList<View>();
	//��������������
	private GuidePagerAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����������ȥ
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		
		guideViewPager = (ViewPager) findViewById(R.id.guide_view_pager);
		//��ʼ��ViewPager�е�ͼƬ�������б�
		initViews();
		
		//����������
		adapter = new GuidePagerAdapter(picsList);
		guideViewPager.setAdapter(adapter);
		//����ViewPager���ݸı�
		guideViewPager.setOnPageChangeListener(this);
		
	}


	private void initViews() {
		//��ͼƬ���ֲ����������params
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		for(int i = 0; i < pics.length; i ++ ) {
			ImageView iv = new ImageView(this);
			//����ͼƬ���ָ�ʽ
			iv.setLayoutParams(params);
			//����ͼƬ��ʾ��Դ
			iv.setImageResource(pics[i]);
			//��ͼƬ�����б�����������ʹ��
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
		//���ڽ�ViewPager���ͼƬֱ�ӷ������飬
		//û�е�����xml�ļ����ò��֣����Button
		//����Button��������¼�����תMainActivity�����Ի�һЩ
		
		//������ͼƬ�������һ��ʱ���Զ���תMainActivity
		if(arg0 == pics.length - 1) {
			startActivity(new Intent(GuideActivity.this, MainActivity.class));
			finish();
		}
		
	}

}
