package me.domain;

public class Classes {
	// 班级id
	private int cid;
	// 班级名称
	private String cname;
	// 年级
	private int grade;
	// 人数
	private int num;

	public Classes(int cid, String cname, int grade, int num) {
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
		this.num = num;
	}

	public Classes(int cid, String cname, int grade) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
