package com.example.markthespot;

public class ForFeeds {
	private String name;
	private String room;
	private int iconID;
	private String time;
	
	public ForFeeds(String name, String room, int iconID, String time) {
		super();
		this.name = name;
		this.room = room;
		this.iconID = iconID;
		this.time = time;
	}

	public String getName() {
		return name;
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


