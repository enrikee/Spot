package com.example.markthespot;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.view.*;

public class Photos extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_photos);
	    getActionBar().setDisplayHomeAsUpEnabled(true);

	    GridView gridview = (GridView)findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(Photos.this, "" + position, Toast.LENGTH_SHORT).show();
	          //  int img = (Integer) gridview.getItemAtPosition(position);
               // Intent intent = new Intent(Photos.this,FullImage.class);
               // intent.putExtra("IMAGE",img);
               // startActivity(intent);
	        }
	    });
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
}

