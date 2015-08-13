package com.useease.goyunnan;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.useease.adapter.ScenicSpotBaseAdapterspinner1;
import com.useease.adapter.ScenicSpotBaseAdapterspinner2;
import com.useease.adapter.ScenicSpotBaseAdapterspinner3;
import com.useease.adapter.ScenicSpotListViewBaseAdapter;
import com.useease.width.Users;

public class ScenicSpot extends Activity implements OnScrollListener{
	private Spinner cityspinner, Distancespinner,Scorespinner;
	private ListView citylist;
	private List<Users> list;
	private ImageView back;
	private ScenicSpotListViewBaseAdapter adapter5;
	private View moreView;
	private int lastItem;
    private int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scenicspot);
		back=(ImageView) findViewById(R.id.scenicspotimage1);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ScenicSpot.this,MainActivity.class));
			}
		});
		cityspinner=(Spinner) findViewById(R.id.scenicspotspinner1);
		Distancespinner=(Spinner) findViewById(R.id.scenicspotspinner2);
		Scorespinner=(Spinner) findViewById(R.id.scenicspotspinner3);
		citylist=(ListView) findViewById(R.id.scenicspotlist);
		String s1[]={"全市","昆明市"};
		//下拉菜单适配器
		ScenicSpotBaseAdapterspinner1 adapter1=new ScenicSpotBaseAdapterspinner1(ScenicSpot.this);
		ScenicSpotBaseAdapterspinner2 adapter2=new ScenicSpotBaseAdapterspinner2(ScenicSpot.this);
		ScenicSpotBaseAdapterspinner3 adapter3=new ScenicSpotBaseAdapterspinner3(ScenicSpot.this);

		for (int i = 0; i < s1.length; i++) {
			Users user=new Users();
			user.setContext1(s1[i]);
			adapter1.addItem(user);
			adapter2.addItem(user);
			adapter3.addItem(user);
		}	
		cityspinner.setAdapter(adapter1);
		Distancespinner.setAdapter(adapter2);
		Scorespinner.setAdapter(adapter3);
		
		//listview的适配器
		list=new ArrayList<Users>();
		/*for (int i = 0; i < distance.length; i++) {
			Users user1=new Users();
			user1.setContext3(name[i]);
			user1.setContext4(distance[i]);
			list.add(user1);
		}*/
		
		moreView = getLayoutInflater().inflate(R.layout.load, null);
		prepareData();
		count=list.size();
		adapter5=new ScenicSpotListViewBaseAdapter(ScenicSpot.this,list);
		citylist.addFooterView(moreView);
		citylist.setAdapter(adapter5);
		citylist.setOnScrollListener(this);
		citylist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(ScenicSpot.this, "你点击了"+arg2, 1).show();	
			}
		});
	}
	 private void prepareData(){  //准备数据
	    	for(int i=0;i<5;i++){
	    		Users user1=new Users();
				user1.setContext3("石林"+i);
				user1.setContext4(i+".0Km");
				list.add(user1);
	    	}
	    	
	    }
	  
	    private void loadMoreData(){ //加载更多数据
	    	 count = adapter5.getCount(); 
	    	for(int i=count;i<count+5;i++){
	    		Users user1=new Users();
				user1.setContext3("石林"+i);
				user1.setContext4(i+".0Km");
				list.add(user1);
	    	}
	    	count = list.size();
	    }
	    
	    public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			
			
			lastItem = firstVisibleItem + visibleItemCount - 1;  //减1是因为上面加了个addFooterView
			
		}
	    
	    public void onScrollStateChanged(AbsListView view, int scrollState) { 
			//下拉到空闲是，且最后一个item的数等于数据的总数时，进行更新
			if(lastItem == count  && scrollState == this.SCROLL_STATE_IDLE){ 
				moreView.setVisibility(view.VISIBLE);
			 
			    mHandler.sendEmptyMessage(0);
				 
			}
			
		}
		//声明Handler
		private Handler mHandler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				switch (msg.what) {
				case 0:
				     
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    loadMoreData();  //加载更多数据，这里可以使用异步加载
				    adapter5.notifyDataSetChanged();
				    moreView.setVisibility(View.GONE); 
				    
				    if(count > 13){
				    	Toast.makeText(ScenicSpot.this, "木有更多数据！", 3000).show();
				          citylist.removeFooterView(moreView); //移除底部视图
				    }
					break;
	            case 1:
					
					break;
				default:
					break;
				}
			};
		};

}
