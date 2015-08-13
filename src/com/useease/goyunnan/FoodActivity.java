package com.useease.goyunnan;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends Activity {
	private int menuId = R.menu.actionbar_food;
	private LinearLayout Layout_kind[] = new LinearLayout[4];
	private LinearLayout layout[] = new LinearLayout[4],
			layout2[] = new LinearLayout[4];
	private ImageButton ib[] = new ImageButton[4];
	private View views[] = new View[16];
	private LayoutInflater inflater;
	private ImageView img ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food);
		ActionBar actionbar = getActionBar();
		actionbar.setTitle("返回");
		actionbar.setDisplayShowTitleEnabled(true);
		actionbar.setDisplayHomeAsUpEnabled(true);
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		img = new ImageView(getApplicationContext());
		img.setBackgroundResource(R.drawable.test);
		
		inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f);
		LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1.0f);
		params.setMargins(6, 6, 6, 6);

		params2.setMargins(6, 6, 6, 6);
		for (int i = 0; i < 16; i++) {
			views[i] = inflater.inflate(R.layout.food_shop, null);
			views[i].setLayoutParams(params);
			views[i].setId(i);
			// TextView tv = (TextView) views[i].findViewById(R.id.tv);
			// views[i].setBackgroundResource(R.drawable.ic_launcher);
			views[i].setOnClickListener(new MyOnClickListener());

		}
		LinearLayout L0 = (LinearLayout) findViewById(R.id.L0);
		L0.setOnClickListener(new MyOnClickListener());
		for (int i = 0; i < 4; i++) {
			ib[i] = (ImageButton) findViewById(R.id.kind1 + i);
			ib[i].setOnClickListener(new MyOnClickListener());
			layout[i] = new LinearLayout(getApplicationContext());
			layout2[i] = new LinearLayout(getApplicationContext());
			layout[i].setLayoutParams(params2);
			layout2[i].setLayoutParams(params2);
			layout[i].addView(views[4 * i]);
			layout[i].addView(views[1 + 4 * i]);
			layout2[i].addView(views[2 + 4 * i]);
			layout2[i].addView(views[3 + 4 * i]);
			Layout_kind[i] = (LinearLayout) findViewById(R.id.L1 + i);
			Layout_kind[i].addView(layout[i]);
			Layout_kind[i].addView(layout2[i]);
			Layout_kind[i].setOnClickListener(new MyOnClickListener());
		}

	}

	class MyOnClickListener implements OnClickListener {

		public void onClick(View v) {// 或直接跟上要执行的动作

			if (v.getId() < 16) {
				Toast.makeText(getApplicationContext(), "" + v.getId(), 0).show();
			}
			if (v.getId() == R.id.L1 || v.getId() == R.id.kind1) {
				Toast.makeText(getApplicationContext(), "kind1", 0).show();
			}
			if (v.getId() == R.id.L2 || v.getId() == R.id.kind2) {
				Toast.makeText(getApplicationContext(), "kind2", 0).show();
			}
			if (v.getId() == R.id.L3 || v.getId() == R.id.kind3) {
				Toast.makeText(getApplicationContext(), "kind3", 0).show();
			}
			if (v.getId() == R.id.L4 || v.getId() == R.id.kind4) {
				Toast.makeText(getApplicationContext(), "kind4", 0).show();
			}
			if(v.getId()== R.id.L0){
					Toast.makeText(getApplicationContext(), "ALLKIND", 0).show();
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(menuId, menu);
		setUpSearchView(menu);
		return true;
	}

	private void setUpSearchView(Menu menu) {
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
				.getActionView();
		if (searchView == null) {
			return;
		}
		searchView.setIconifiedByDefault(true);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		ComponentName cn = new ComponentName(this, SearchResultActvity.class);
		SearchableInfo info = searchManager.getSearchableInfo(cn);
		if (info == null) {
		}
		searchView.setSearchableInfo(info);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// 方式三：无需代码特别处理，
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
