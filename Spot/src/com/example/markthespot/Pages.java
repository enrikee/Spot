package com.example.markthespot;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pages extends Activity {

	private List<ForComment> myComment = new ArrayList<ForComment>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pages);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Bundle extras = getIntent().getExtras();
		String name = extras.getString("name");
		TextView textV = (TextView)findViewById(R.id.spot_name);
		textV.setText(name);
		
		Button button_show = (Button)findViewById(R.id.button_show);
		button_show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Toast.makeText(getApplicationContext(),
	                     "You have checked in!", Toast.LENGTH_LONG)
	                     .show();
				 Intent i2 = new Intent(getApplicationContext(),Profile.class);
				 startActivity(i2);
				
			}
		});
		
		populateCommentsList();
		populateListView();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		case R.id.action_fave:
			 Toast.makeText(getApplicationContext(),
                     "Added to check list!", Toast.LENGTH_LONG)
                     .show();
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


	private void populateCommentsList() {
	
	myComment.add(new ForComment("Enricke", "So Nice", R.drawable.kee, "25 mins ago"));
	myComment.add(new ForComment("Louie", "Very Beautiful", R.drawable.louie, "28 mins ago"));
	myComment.add(new ForComment("Joseph", "LB467", R.drawable.joseph, "29 mins ago"));
	myComment.add(new ForComment("Karl", "LB468", R.drawable.karl, "31 mins ago"));
	myComment.add(new ForComment("Debbie", "LB469", R.drawable.debbie, "35 mins ago"));
	myComment.add(new ForComment("Erwin", "LB485", R.drawable.erwin, "37 mins ago"));
	myComment.add(new ForComment("Irvin", "LB486", R.drawable.irvin, "39 mins ago"));
	myComment.add(new ForComment("Paulo", "LB486", R.drawable.paulo, "39 mins ago"));
	myComment.add(new ForComment("Ram", "LB486", R.drawable.ram, "39 mins ago"));
	myComment.add(new ForComment("Christian", "LB486", R.drawable.ompad,"39 mins ago"));
	
}

private void populateListView() {
	ArrayAdapter<ForComment> adapter = new MyListAdapter();
	ListView list = (ListView) findViewById(R.id.comments);
	list.setAdapter(adapter);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.pages, menu);
		return true;	
	}
	
	private class MyListAdapter extends ArrayAdapter<ForComment> {
		public MyListAdapter() {
			super(Pages.this, R.layout.activity_comments, myComment);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if(itemView == null)
				itemView = getLayoutInflater().inflate(R.layout.activity_comments, parent, false);
			
			//find friend to work with
			ForComment currentComment = myComment.get(position);
			
			//fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.com_icon);
			imageView.setImageResource(currentComment.getIconID());
			
			TextView nameText = (TextView) itemView.findViewById(R.id.com_textFriend);
			nameText.setText(currentComment.getName()); 
			
			TextView roomText = (TextView) itemView.findViewById(R.id.comment);
			roomText.setText(currentComment.getComment());
			
			TextView timeText = (TextView) itemView.findViewById(R.id.com_textTime);
			timeText.setText(currentComment.getTime());
			
			
			return itemView;
			
		}
		
		
	}

	

}
