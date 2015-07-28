package com.useease.goyunnan;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class LoginActivity extends Activity{
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    
    ActionBar actionbar = getActionBar();
    actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    actionbar.setTitle("返回");
    actionbar.setDisplayShowTitleEnabled(true);
    actionbar.setDisplayHomeAsUpEnabled(true);
    actionbar.setCustomView(R.layout.actionbar_d);}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:// 点击返回图标事件
        this.finish();
    default:
        return super.onOptionsItemSelected(item);
    }
}
}
