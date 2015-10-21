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
	
	//获取当前列表中界面的个数
	@Override
	public int getCount() {
		if(mList != null) {
			return mList.size();
		}
		return 0;
	}

	//判断是否由对象生成界面
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	//销毁position位置的view
	@Override
	public void destroyItem(View view, int position, Object object) {
		((ViewPager) view).removeView(mList.get(position));
		}

	//初始化position位置的view
	@Override
	public Object instantiateItem(View view, int position) {
		((ViewPager) view).addView(mList.get(position));
		return mList.get(position);
	}

}
