package me.hujianfei.activity;

import java.util.ArrayList;

import me.hujianfei.scrolloverlistview.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class ListViewActivity extends Activity
{
	
	private ListView   mListView;
	private ListViewAdapter mAdapter;
	
	private ArrayList<String >  mData;
 	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		
		initData();
		initView();
	}
	
	
	private void initView()
	{
		mListView = (ListView)findViewById(R.id.listviewNormal);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		mAdapter = new ListViewAdapter(getApplicationContext());
		mAdapter.setArrayList(mData);
		
		mListView.setAdapter(mAdapter);
	}
	
	
	private void initData()
	{
		this.mData = new ArrayList<>();
		for (int i = 0; i < 300; i++) 
		{
			this.mData.add(String.format("这是ListView 的第%d项.", i));
		}
		
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
