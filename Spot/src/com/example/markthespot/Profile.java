package com.example.markthespot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends Activity {
	
	private List<ForProfile> mySpots = new ArrayList<ForProfile>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
/*		
		Bundle extras = getIntent().getExtras();
		String name = extras.getString("ProfName");
		int profpic = extras.getInt("ProfPic");
		TextView textV = (TextView)findViewById(R.id.prof_name);
		textV.setText(name);
		ImageView imgV = (ImageView)findViewById(R.id.prof_image);
		imgV.setImageResource(profpic);
*/	
		populateSpotsList();
		populateListView();
		
		ListView listView;
		ArrayAdapter<ForProfile> adapter = new MyListAdapter();
		listView = (ListView)findViewById(R.id.spotsListView);
		listView.setAdapter(adapter);

		Button photoButton = (Button)findViewById(R.id.button_photos);
		photoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),Photos.class);
				startActivity(i);
				
			}
		});
		
		Button button_friend = (Button)findViewById(R.id.button_friends);
		button_friend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),Friends.class);
				startActivity(i);
				
			}
		});
		
		Button button_spot = (Button)findViewById(R.id.button_spots);
		button_spot.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),Spots.class);
				startActivity(i);
				
			}
		});
	
	Button button_checklist = (Button)findViewById(R.id.button_checklist);
	button_checklist.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent(getApplicationContext(),CheckList.class);
			startActivity(i);
			
		}
	});
}


	private void populateSpotsList() {
		mySpots.add(new ForProfile("LB470", R.drawable.ic_action_place, "25 mins ago"));
		mySpots.add(new ForProfile("LB466", R.drawable.ic_action_place, "28 mins ago"));
		mySpots.add(new ForProfile("LB467", R.drawable.ic_action_place, "29 mins ago"));
		mySpots.add(new ForProfile("LB468", R.drawable.ic_action_place, "31 mins ago"));
		mySpots.add(new ForProfile("LB469", R.drawable.ic_action_place, "35 mins ago"));
		mySpots.add(new ForProfile("LB485", R.drawable.ic_action_place, "37 mins ago"));
		mySpots.add(new ForProfile("LB486", R.drawable.ic_action_place, "39 mins ago"));
		
	}
	
	private void populateListView() {
		ArrayAdapter<ForProfile> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.spotsListView);
		list.setAdapter(adapter);
	}
	
	private class MyListAdapter extends ArrayAdapter<ForProfile> {
		public MyListAdapter() {
			super(Profile.this, R.layout.item_view_profile, mySpots);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if(itemView == null)
				itemView = getLayoutInflater().inflate(R.layout.item_view_profile, parent, false);
			
			//find friend to work with
			ForProfile currentSpot = mySpots.get(position);
			
			//fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
			imageView.setImageResource(currentSpot.getIconID());
			
			TextView roomText = (TextView) itemView.findViewById(R.id.item_textRoom);
			roomText.setText(currentSpot.getRoom());
			
			TextView timeText = (TextView) itemView.findViewById(R.id.item_textTime);
			timeText.setText(currentSpot.getTime());
			
			
			return itemView;
			
		}
		
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;	
	}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	super.onOptionsItemSelected(item);
	switch (item.getItemId()) {
    // Respond to the action bar's Up/Home button
    case android.R.id.home:
        NavUtils.navigateUpFromSameTask(this);
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

}



