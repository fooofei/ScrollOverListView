package me.hujianfei.activity;

import me.hujianfei.scrolloverlistview.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
	
	public static final String URL_ON_GITHUB = "https://github.com/feiongithub/ScrollOverListView";
	private Button mbtnNormalListView;
	private Button mbtnScrollOverListView;
	private Button mbtnNormalListViewAddHeader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	public void initView()
	{
		mbtnNormalListView = (Button)findViewById(R.id.btnNormalListView);
		mbtnScrollOverListView = (Button)findViewById(R.id.btnScrollOverListView);
		mbtnNormalListViewAddHeader = (Button)findViewById(R.id.btnNormalListViewAddHeader);
		
		mbtnNormalListView.setOnClickListener(clickListener);
		mbtnScrollOverListView.setOnClickListener(clickListener);
		mbtnNormalListViewAddHeader.setOnClickListener(clickListener);
	}
	
	private android.view.View.OnClickListener clickListener = new View.OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Intent intent = new Intent();
			switch (v.getId())
			{
			case R.id.btnNormalListView:
				intent.setClass(getApplicationContext(), ListViewActivity.class);
				break;

			case R.id.btnScrollOverListView:
				intent.setClass(getApplicationContext(), ScrollOverListViewActivity.class);
				break;
				
			case R.id.btnNormalListViewAddHeader:
				
				intent.setClass(getApplicationContext(), ListViewAddHeaderActivity.class);
				break;
			default:
				break;
			}
			
			startActivity(intent);
		}
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if (id == R.id.menuLink)
		{
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(URL_ON_GITHUB));
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
