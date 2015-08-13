package com.useease.adapter;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.useease.goyunnan.R;
import com.useease.width.Users;

public class ScenicSpotBaseAdapterspinner1 extends BaseAdapter {

	private LinkedList<Users> items;
	private LayoutInflater inflater;
	public ScenicSpotBaseAdapterspinner1(Context context){
		items=new LinkedList<Users>();
		inflater=LayoutInflater.from(context);
	}
	public void addItem(Users user) {
		items.add(user);
		this.notifyDataSetChanged();
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
			convertView=inflater.inflate(R.layout.scenicspot_spinneritem1,null);
			holder=new ViewHolder();
			holder.contextTextView1=(TextView) convertView.findViewById(R.id.textView1);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.contextTextView1.setText(items.get(position).getContext1());
		return convertView;
	}
	public class ViewHolder{
		TextView contextTextView1,contextTextView2;
	}

}
