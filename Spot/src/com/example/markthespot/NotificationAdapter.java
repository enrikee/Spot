package com.example.markthespot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NotificationAdapter extends ArrayAdapter<String>{
	Context context;
	int[] images;
	String[] names;
	String[] rooms;
	String[] time;
	public NotificationAdapter(Context con, int image[], String[] name, String[] room, String[] time){	
		super(con,R.layout.activity_notification,R.id.noti_name,name);
		this.context = con;
		this.images = image;
		this.names = name;
		this.rooms = room;
		this.time = time;
		
	}

public class MyViewHolder{
	ImageView image;
	TextView name;
	TextView room;
	TextView time;
	public MyViewHolder(View v){
		image = (ImageView) v.findViewById(R.id.noti_image);
		name = (TextView) v.findViewById(R.id.noti_name);
		room = (TextView) v.findViewById(R.id.noti_room);
		time = (TextView) v.findViewById(R.id.noti_time);
	}
}
	
	@Override
	public View getView(int position, View convertView , ViewGroup parent){
		View row = convertView;
		MyViewHolder hold = null;
		if(row==null){
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.activity_notification, parent, false);
		hold = new MyViewHolder(row);
		row.setTag(hold);
		}
		else{
			hold = (MyViewHolder) row.getTag();
		}
		hold.image.setImageResource(images[position]);
		hold.name.setText(names[position]);
		hold.room.setText(rooms[position]);
		hold.time.setText(time[position]);
		
	return row;
	}
}
