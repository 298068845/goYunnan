package com.useease.goyunnan;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
	public class SlideActivity extends Activity {
	
	private ViewPager viewpager = null;
	private List<View> list = null;
	private ImageView[] img = null;
	private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        list = new ArrayList<View>();

        list.add(getLayoutInflater().inflate(R.layout.tab1, null));
        list.add(getLayoutInflater().inflate(R.layout.tab2, null));
        list.add(getLayoutInflater().inflate(R.layout.tab3, null));

        img = new ImageView[list.size()];
        LinearLayout layout = (LinearLayout) findViewById(R.id.viewGroup);
        for (int i = 0; i < list.size(); i++) {
            img[i] = new ImageView(SlideActivity.this);
            if (0 == i) {
                img[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                img[i].setBackgroundResource(R.drawable.page_indicator);
            }
            img[i].setPadding(0, 0, 20, 0);
            layout.addView(img[i]);
        }

        viewpager.setAdapter(new ViewPagerAdapter(list));
        viewpager.setOnPageChangeListener(new ViewPagerPageChangeListener());

    }
    
    class ViewPagerAdapter extends PagerAdapter {
    	 
        private List<View> list = null;
 
        public ViewPagerAdapter(List<View> list) {
            this.list = list;
        }
 
        @Override
        public int getCount() {
            return list.size();
        }
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));

            if(position==2){
                btn=(Button)list.get(position).findViewById(R.id.start);
                btn.setOnClickListener(new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				Intent intent= new Intent();
        				intent.setClass(SlideActivity.this, MainActivity.class);
        				startActivity(intent);
        			}
        		});
            }
            return list.get(position);
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
 
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
 
    }
    
    class ViewPagerPageChangeListener implements OnPageChangeListener {
    	 

        @Override
        public void onPageScrollStateChanged(int state) {
        }
 
 
        @Override
        public void onPageScrolled(int page, float positionOffset,
                int positionOffsetPixels) {
        }
 
        @Override
        public void onPageSelected(int page) {
            for (int i = 0; i < list.size(); i++) {
                if (page == i) {
                    img[i].setBackgroundResource(R.drawable.page_indicator_focused);
                } else {
                    img[i].setBackgroundResource(R.drawable.page_indicator);
                }
            }
        }
    }
}
