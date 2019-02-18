package me.domain;

public class Classes {
	private int cid; // 班级id
	private String cname; // 班级名称
	private int grade; // 年级

	public Classes(int cid, String cname, int grade) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return ("cid = " + cid + ", name = " + cname + ", grade = " + grade);
	}
}
