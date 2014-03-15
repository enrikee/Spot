package com.example.markthespot;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Friends extends ListActivity {

	int[] image = {R.drawable.irvin,R.drawable.erwin,R.drawable.debbie,R.drawable.kee,R.drawable.ompad,R.drawable.joseph,R.drawable.karl,R.drawable.paulo,R.drawable.mike,R.drawable.ram};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Resources res = getResources();
		String[] name = res.getStringArray(R.array.names);
		FriendsAdapter adapter = new FriendsAdapter(this,image, name);
		setListAdapter(adapter);
		getActionBar().setDisplayHomeAsUpEnabled(true);
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.profile, menu);
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
    case R.id.action_profile:
    	Intent i = new Intent(getApplicationContext(),Profile.class);
    	startActivity(i);
    	break;
    }
    return true;
}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String item = (String) getListAdapter().getItem(position);
		Intent i = new Intent(this, Profile.class);
		i.putExtra("ProfPic", image[position]);
		i.putExtra("ProfName", item);
		startActivity(i);
		//Toast.makeText(this, item + "  selected", Toast.LENGTH_SHORT).show();
	}
}
