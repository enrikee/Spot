package com.example.markthespot;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class FriendsAdapter extends ArrayAdapter<String>{
	Context context;
	int[] images;
	String [] names;
	public FriendsAdapter(Context con, int image[], String[] name){	
		super(con,R.layout.activity_friends,R.id.label,name);
		this.context = con;
		this.images = image;
		this.names = name;
	}

public class MyViewHolder{
	ImageView image;
	TextView name;
	public MyViewHolder(View v){
		image = (ImageView) v.findViewById(R.id.icon);
		name = (TextView) v.findViewById(R.id.label);
		
	}
	

}
	
	@Override
	public View getView(int position, View convertView , ViewGroup parent){
		View row = convertView;
		MyViewHolder hold = null;
		if(row==null){
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.activity_friends, parent, false);
		hold = new MyViewHolder(row);
		row.setTag(hold);
		}
		else{
			hold = (MyViewHolder)row.getTag();
		}
		
		hold.image.setImageResource(images[position]);
		hold.name.setText(names[position]);
		
	return row;
	}
}
