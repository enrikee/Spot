package com.example.markthespot;

public class ForProfile {
	private String room;
	private int iconID;
	private String time;
	
	public ForProfile(String room, int iconID, String time) {
		super();
		this.room = room;
		this.iconID = iconID;
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public int getIconID() {
		return iconID;
	}

	public String getTime() {
		return time;
	}
}


