package com.example.markthespot;

import java.util.ArrayList;
import java.util.List;

import com.example.markthespot.Profile;
import com.example.markthespot.R;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Feeds extends Activity {
	
	private List<ForFeeds> myFeeds = new ArrayList<ForFeeds>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feeds);
		
		populateFeedsList();
		populateListView();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.feeds, menu);
		
		// Associate searchable configuration with the SearchView
	    SearchManager searchManager =
	           (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    SearchView searchView =
	            (SearchView) menu.findItem(R.id.action_search).getActionView();
	    searchView.setSearchableInfo(
	            searchManager.getSearchableInfo(getComponentName()));

	    
		return true;	
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.action_profile:
	    	Intent i = new Intent(getApplicationContext(),Profile.class);
	    	startActivity(i);
	    	break;
		case R.id.action_location:
			Intent i1 = new Intent(getApplicationContext(),Map.class);
			startActivity(i1);
			break;
		case R.id.action_settings:
			 Toast.makeText(getApplicationContext(),
                     "You have logged out", Toast.LENGTH_LONG)
                     .show();
			 Intent i2 = new Intent(getApplicationContext(),MainActivity.class);
			 startActivity(i2);
			 break;
			
	    }
	    return true;

	}
	

	private void populateFeedsList() {
		myFeeds.add(new ForFeeds("Enricke", "LB470", R.drawable.kee, "25 mins ago"));
		myFeeds.add(new ForFeeds("Louie", "LB466", R.drawable.louie, "28 mins ago"));
		myFeeds.add(new ForFeeds("Joseph", "LB467", R.drawable.joseph, "29 mins ago"));
		myFeeds.add(new ForFeeds("Karl", "LB468", R.drawable.karl, "31 mins ago"));
		myFeeds.add(new ForFeeds("Debbie", "LB469", R.drawable.debbie, "35 mins ago"));
		myFeeds.add(new ForFeeds("Erwin", "LB485", R.drawable.erwin, "37 mins ago"));
		myFeeds.add(new ForFeeds("Irvin", "LB486", R.drawable.irvin, "39 mins ago"));
		myFeeds.add(new ForFeeds("Paulo", "LB486", R.drawable.paulo, "39 mins ago"));
		myFeeds.add(new ForFeeds("Ram", "LB486", R.drawable.ram, "39 mins ago"));
		myFeeds.add(new ForFeeds("Christian", "LB486", R.drawable.ompad,"39 mins ago"));
		
	}
	
	private void populateListView() {
		ArrayAdapter<ForFeeds> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.feedsListView);
		list.setAdapter(adapter);
		
	}
	
	private class MyListAdapter extends ArrayAdapter<ForFeeds> {
		public MyListAdapter() {
			super(Feeds.this, R.layout.item_view_feeds, myFeeds);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if(itemView == null)
				itemView = getLayoutInflater().inflate(R.layout.item_view_feeds, parent, false);
			
			//find friend to work with
			ForFeeds currentFeed = myFeeds.get(position);
			
			//fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
			imageView.setImageResource(currentFeed.getIconID());
			
			TextView nameText = (TextView) itemView.findViewById(R.id.item_textFriend);
			nameText.setText(currentFeed.getName()); 
			
			TextView roomText = (TextView) itemView.findViewById(R.id.item_textRoom);
			roomText.setText(currentFeed.getRoom());
			
			TextView timeText = (TextView) itemView.findViewById(R.id.item_textTime);
			timeText.setText(currentFeed.getTime());
			
			
			return itemView;
			
		}
		
		
	}
	

}
