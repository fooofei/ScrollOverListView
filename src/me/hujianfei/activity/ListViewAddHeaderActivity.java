package me.hujianfei.activity;

import java.util.ArrayList;
import java.util.List;

import me.hujianfei.scrolloverlistview.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewAddHeaderActivity extends Activity {

	private ListView   mListView;
	private ArrayAdapter<String> adapter;
 	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		initView();
		initData();
		
		this.mListView.setAdapter(this.adapter);
		
	}
	
	
	@SuppressLint("InflateParams")
	private void initView()
	{
		mListView = (ListView)findViewById(R.id.listViewNormal);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		View headerView = LayoutInflater.from(this).inflate(R.layout.listview_item_top, null);
		this.mListView.addHeaderView(headerView);
	}
	
	
	public void initData()
	{
		List<String> dataList = new ArrayList<String>();

		for (int i = 0; i < 300; i++)
		{
			dataList.add(String.format("这是ListView 的第%d项.", i));
		}

		this.adapter = new ArrayAdapter<String>(this, R.layout.listview_item,
				R.id.listViewItemText, dataList);
		
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
