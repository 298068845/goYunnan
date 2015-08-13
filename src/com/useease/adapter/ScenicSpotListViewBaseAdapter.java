package com.useease.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.useease.goyunnan.R;
import com.useease.goyunnan.ScenicSpot;
import com.useease.goyunnan.ScenicSpotImageActivity;
import com.useease.width.Users;

public class ScenicSpotListViewBaseAdapter extends BaseAdapter {
	private List<Users> items;
	private LayoutInflater inflater;
	private Context context;
	public ScenicSpotListViewBaseAdapter(Context context,List<Users> items){
		this.items=items;
		this.context=context;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if(convertView==null){
			inflater=LayoutInflater.from(context);
			convertView=inflater.inflate(R.layout.scenicspot_listitem, null);
			holder=new ViewHolder();
			holder.contextTextView1=(TextView) convertView.findViewById(R.id.scenicspotlistitemtext1);
			holder.contextTextView2=(TextView) convertView.findViewById(R.id.scenicspotlistitemtext5);
			holder.contextimageview=(ImageView) convertView.findViewById(R.id.scenicspotlistitemimage1);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		holder.contextTextView1.setText(items.get(position).getContext3());
		holder.contextTextView2.setText(items.get(position).getContext4());
		holder.contextimageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.startActivity(new Intent(context,ScenicSpotImageActivity.class));
			}
		});
		return convertView;
	}

	public class ViewHolder{
		ImageView contextimageview;
		TextView contextTextView1,contextTextView2;
	}
}
