package com.useease.goyunnan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.useease.adapter.ScenicSpotImageGridViewBaseAdapter;
import com.useease.width.MyDialog;
import com.useease.width.MyGridView;
import com.useease.width.PopMenu;
import com.useease.width.Users;

public class ScenicSpotImageActivity extends Activity{
	private ImageView menu,back,dialogimage;
	private Context context;
	private PopMenu popMenu;
	private MyGridView mgridview;
	private RatingBar bar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scenicspotimageactivity);
		String mGV[]={"小石林景区","步哨山景区","大石林景区","万年灵芝景区"};
		bar=(RatingBar) findViewById(R.id.scenicspotratingbaractivity);
		dialogimage=(ImageView) findViewById(R.id.scenicspotimageactivity8);
		mgridview=(MyGridView) findViewById(R.id.scenicspotgridviewactivity);
		back=(ImageView) findViewById(R.id.scenicspotimageactivity1);
		menu=(ImageView) findViewById(R.id.scenicspotimageactivity2);
		context=ScenicSpotImageActivity.this;
		popMenu = new PopMenu(context);
		String s[]={"我要收藏","分享微信","分享微博","我要投诉","我要维权"};
		for (int i = 0; i < s.length; i++) {
			Users user=new Users();
			user.setContext1(s[i]);
			popMenu.addItems(user);
		}
		popMenu.setOnItemClickListener(popmenuItemClickListener);
		menu.setOnClickListener(listener);
		back.setOnClickListener(listener);
		dialogimage.setOnClickListener(listener);
		
		//gridview代码处
		ScenicSpotImageGridViewBaseAdapter madapter=new ScenicSpotImageGridViewBaseAdapter(ScenicSpotImageActivity.this);
		for (int i = 0; i < mGV.length; i++) {
			Users user=new Users();
			user.setContext1(mGV[i]);
			madapter.addItem(user);
		}
		mgridview.setAdapter(madapter);
	}
	public OnItemClickListener popmenuItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			switch (position) {
			case 0:
				Toast.makeText(ScenicSpotImageActivity.this, "点击" + position,
						Toast.LENGTH_SHORT).show();
				popMenu.dismiss();
				break;
			case 1:
				Toast.makeText(ScenicSpotImageActivity.this, "点击" + position,
						Toast.LENGTH_SHORT).show();
				popMenu.dismiss();
				break;
			case 2:
				Toast.makeText(ScenicSpotImageActivity.this, "点击" + position,
						Toast.LENGTH_SHORT).show();
				popMenu.dismiss();
				break;
			case 3:
				Toast.makeText(ScenicSpotImageActivity.this, "点击" + position,
						Toast.LENGTH_SHORT).show();
				popMenu.dismiss();
				break;
			case 4:
				Toast.makeText(ScenicSpotImageActivity.this, "点击" + position,
						Toast.LENGTH_SHORT).show();
				popMenu.dismiss();
				break;

			default:
				break;
			}
		}
	};
	public OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.scenicspotimageactivity1:
				startActivity(new Intent(ScenicSpotImageActivity.this,ScenicSpot.class));
				break;
			case R.id.scenicspotimageactivity2:
				popMenu.showAsDropDown(v);
				break;
			case R.id.scenicspotimageactivity8:
				LayoutInflater inflater=LayoutInflater.from(ScenicSpotImageActivity.this);
				View view=inflater.inflate(R.layout.scenicspotimagedialogactivity, null);
				LinearLayout lay1=(LinearLayout) view.findViewById(R.id.l1);
				LinearLayout lay2=(LinearLayout) view.findViewById(R.id.l2);
				LinearLayout lay3=(LinearLayout) view.findViewById(R.id.l3);
				LinearLayout lay4=(LinearLayout) view.findViewById(R.id.l4);
				LinearLayout lay5=(LinearLayout) view.findViewById(R.id.l5);
				final RatingBar b1=(RatingBar) view.findViewById(R.id.bar1);
				final RatingBar b2=(RatingBar) view.findViewById(R.id.bar2);
				final RatingBar b3=(RatingBar) view.findViewById(R.id.bar3);
				final RatingBar b4=(RatingBar) view.findViewById(R.id.bar4);
				final RatingBar b5=(RatingBar) view.findViewById(R.id.bar5);
				final MyDialog dialog=new MyDialog();
				dialog.mydialog(ScenicSpotImageActivity.this, view);
				lay1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						bar.setRating(b1.getRating());
						dialog.dismiss();
					}
				});
				
				lay2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						bar.setRating(b2.getRating());
						dialog.dismiss();
					}
				});

				lay3.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						bar.setRating(b3.getRating());
						dialog.dismiss();
					}
				});
				lay4.setOnClickListener(new OnClickListener() {
	
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						bar.setRating(b4.getRating());
						dialog.dismiss();
					}
									});
					lay5.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							bar.setRating(b5.getRating());
							dialog.dismiss();
						}
					});
				break;

			default:
				break;
			}
		}
	};

}
