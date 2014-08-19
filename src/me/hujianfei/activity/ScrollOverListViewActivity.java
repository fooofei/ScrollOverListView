package me.hujianfei.activity;

import java.util.ArrayList;
import java.util.List;

import me.hujianfei.scrolloverlistview.R;
import me.hujianfei.view.ScrollOverListView;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

public class ScrollOverListViewActivity extends Activity
{
	private ArrayAdapter<String> adapter;

	private ScrollOverListView listView;

	private ScrollView scrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrolloverlistview);

		initView();
		initData();

		// 使用了ScrollOverListView 需要将ScrollView 滑动到最上
		this.scrollView.smoothScrollTo(0, 0);
	}

	public void initView()
	{
		this.listView = (ScrollOverListView) findViewById(R.id.list);
		this.scrollView = (ScrollView) findViewById(R.id.scrollView);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	public void initData()
	{
		List<String> dataList = new ArrayList<String>();

		for (int i = 0; i < 200; i++)
		{
			dataList.add(String.valueOf(i));
		}

		this.adapter = new ArrayAdapter<String>(this, R.layout.scrollover_listview_item,
				R.id.scroll_listview_item_text1, dataList);

		this.listView.setAdapter(this.adapter);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
