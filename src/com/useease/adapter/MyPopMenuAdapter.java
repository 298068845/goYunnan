package com.useease.adapter;

import java.util.Vector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.useease.goyunnan.R;
import com.useease.width.Users;

public class MyPopMenuAdapter extends BaseAdapter {

	Vector<Users> itemList;
	Context mcon;
	
	public MyPopMenuAdapter(Context mcon,Vector<Users> itemList){
		this.mcon=mcon;
		this.itemList=itemList;
	}
	
	@Override
	public int getCount() {
		return itemList.size();
	}

	@Override
	public Object getItem(int position) {
		return itemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mcon).inflate(
					R.layout.meuelist_item, null);
			holder = new ViewHolder();
			holder.groupItem = (TextView) convertView
					.findViewById(R.id.textview);
            holder.image_meue=(ImageView) convertView.findViewById(R.id.image_meue);
            convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.groupItem.setText(itemList.get(position).getContext1());
        holder.image_meue.setImageResource(itemList.get(position).getPic());
		return convertView;
	}

	private final class ViewHolder {
		TextView groupItem;
		ImageView image_meue;
	}
}