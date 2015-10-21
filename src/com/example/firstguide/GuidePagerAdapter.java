package com.example.firstguide;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class GuidePagerAdapter extends PagerAdapter {

	private List<View> mList;
	
	public GuidePagerAdapter(List<View> mList) {
		this.mList = mList;
	}
	
	//��ȡ��ǰ�б��н���ĸ���
	@Override
	public int getCount() {
		if(mList != null) {
			return mList.size();
		}
		return 0;
	}

	//�ж��Ƿ��ɶ������ɽ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	//����positionλ�õ�view
	@Override
	public void destroyItem(View view, int position, Object object) {
		((ViewPager) view).removeView(mList.get(position));
		}

	//��ʼ��positionλ�õ�view
	@Override
	public Object instantiateItem(View view, int position) {
		((ViewPager) view).addView(mList.get(position));
		return mList.get(position);
	}

}
