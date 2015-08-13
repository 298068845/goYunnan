package com.useease.width;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

public class MyDialog {
	AlertDialog dialog;
	public void mydialog(Context context,View view){
		dialog=new AlertDialog.Builder(context).create();
		dialog.setView(view);
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
	}
	public void dismiss() {
		// TODO Auto-generated method stub
		dialog.dismiss();
	}
}
