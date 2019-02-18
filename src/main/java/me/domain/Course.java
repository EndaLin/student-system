package me.domain;

public class Course {
	private int id; // 课程ID
	private String name; // 课程名称

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ("id = " + id + ", name = " + name);
	}
}
