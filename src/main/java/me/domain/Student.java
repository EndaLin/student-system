package me.domain;

public class Student {
	private int sid; // 学生ID
	private String sname; // 学生姓名
	private int cid; // 班级ID
	private String cname; // 班级名称
	private int cgrade; // 年级

	public Student(int sid, String sname, int cid, String cname, int cgrade) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.cgrade = cgrade;
	}

	public Student(String sname, int cid) {
		super();
		this.sid = -1;
		this.sname = sname;
		this.cid = cid;
		this.cname = "";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public int getCgrade() {
		return cgrade;
	}

	public void setCgrade(int cgrade) {
		this.cgrade = cgrade;
	}

	@Override
	public String toString() {
		return ("sid = " + sid + ", sname = " + sname + ", cid = " + cid + ", cname = " + cname + ", cgrade = "
				+ cgrade);
	}
}
