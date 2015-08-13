package com.useease.width;

import java.util.Vector;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.useease.adapter.MyPopMenuAdapter;
import com.useease.goyunnan.R;

public class PopMenu {
	private Vector<Users> itemList;
	private Context context;
	private PopupWindow popupWindow;
	private ListView listView;

	public PopMenu(Context context) {
		this.context = context;
		itemList = new Vector<Users>();

		View view = LayoutInflater.from(context)
				.inflate(R.layout.meuelist, null);

		listView = (ListView) view.findViewById(R.id.menu_listview);
		listView.setAdapter(new MyPopMenuAdapter(context,itemList));
		listView.setFocusableInTouchMode(true);
		listView.setFocusable(true);

		//popupWindow = new PopupWindow(view,380,LayoutParams.WRAP_CONTENT);
		popupWindow = new PopupWindow(view, context.getResources()
				.getDimensionPixelSize(R.dimen.popmenu_width),
				LayoutParams.WRAP_CONTENT);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		listView.setOnItemClickListener(listener);
	}

	public void addItems(Users user) {
		itemList.add(user);
	}

	public void addItem(Users item) {
		itemList.add(item);
	}

	public void showAsDropDown(View parent) {
		popupWindow.showAsDropDown(parent,
				10,
				context.getResources().getDimensionPixelSize(
						R.dimen.popmenu_yoff));

		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.update();
	}

	public void dismiss() {
		popupWindow.dismiss();
	}
}