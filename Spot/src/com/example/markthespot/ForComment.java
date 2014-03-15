package com.example.markthespot;
	
	public class ForComment {
		private String name;
		private String comment;
		private int iconID;
		private String time;
		
	public ForComment(String name, String comment, int iconID, String time) {
		super();
		this.name = name;
		this.comment = comment;
		this.iconID = iconID;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}

	public int getIconID() {
		return iconID;
	}

	public String getTime() {
		return time;
	}
}

