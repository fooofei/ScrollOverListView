package me.hujianfei.activity;

import java.util.ArrayList;

import me.hujianfei.scrolloverlistview.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter 
{

	private Context mContext;
	
	private ArrayList<String > mArrayList;
	
	
	public ListViewAdapter(Context context) 
	{
		super();
		this.mContext = context;
	}
	
	public void setArrayList(ArrayList<String> arrayList)
	{
		mArrayList = arrayList;
	}

	@Override
	public int getCount() 
	{
		// because we add the listview top
		return mArrayList.size()+1;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		
		if (position == 0) 
		{
			convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item_top, null);
			return convertView;
		}
		
		ViewHolder viewHolder = null ;
		if (convertView == null  || convertView.getTag() == null) 
		{
			convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
			
			viewHolder = new ViewHolder();
			viewHolder.tv = (TextView)convertView.findViewById(R.id.listViewItemText);
			
			convertView.setTag(viewHolder);
		}
		else {
			viewHolder =  (ViewHolder)convertView.getTag();
		}
		
		viewHolder.tv.setText(mArrayList.get(position-1));
		return convertView;
	}

	
	static class ViewHolder
	{
		TextView tv;
	}
}
