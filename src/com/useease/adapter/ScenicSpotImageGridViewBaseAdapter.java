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

public class ScenicSpotImageGridViewBaseAdapter extends BaseAdapter {

	private LinkedList<Users> list;
	private LayoutInflater inflater;
	private Context context;
	public ScenicSpotImageGridViewBaseAdapter(Context context){
		list=new LinkedList<Users>();
		inflater=LayoutInflater.from(context);
		this.context=context;
	}
	public void addItem(Users user){
		list.add(user);
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View content, ViewGroup arg2) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if(content==null){
			content=inflater.inflate(R.layout.scenicspotimagegridviewitemactivity, null);
			holder=new ViewHolder();
			holder.textcontent=(TextView) content.findViewById(R.id.scenicspotgridviewitemactivity);
			content.setTag(holder);
		}else{
			holder=(ViewHolder) content.getTag();
		}
		   holder.textcontent.setText(list.get(position).getContext1());
		return content;
	}
	public class ViewHolder{
		TextView textcontent;
	}
}
