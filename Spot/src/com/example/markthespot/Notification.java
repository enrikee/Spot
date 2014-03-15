package com.example.markthespot;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;

public class Notification extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Resources res = getResources();
		int[] image = {R.drawable.irvin,R.drawable.debbie,R.drawable.erwin,R.drawable.joseph,R.drawable.karl,R.drawable.kee,R.drawable.mike,R.drawable.ompad,R.drawable.paulo,R.drawable.ram};
		String[] name = res.getStringArray(R.array.names);
		String[] room = res.getStringArray(R.array.rooms);
		String[] time = res.getStringArray(R.array.time);
		NotificationAdapter adapter = new NotificationAdapter(this, image, name, room, time);
		setListAdapter(adapter);
        
	}

}
