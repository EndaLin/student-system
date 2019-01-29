package me.domain;

public class Score {
	private int sid;  //学生学号
	private String sname;   //学生姓名
	private int cid;  //班级ID
	private String cname; //班级名称
	private int courseid; //课程ID
	private String coursename; //课程名称
	private int grade;  //学期
	private int score;  //成绩

	public Score(int sid, String sname, int cid, String cname, int courseid, String coursename, int grade, int score) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.courseid = courseid;
		this.coursename = coursename;
		this.grade = grade;
		this.score = score;
	}

	public Score(int sid, int courseid,  int grade, int score) {
		super();
		this.sid = sid;
        this.courseid = courseid;
		this.grade = grade;
		this.score = score;
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
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return ("sid = " + sid +
                ", sname = " + sname +
                ", cid = " + cid +
                ", cname = " + cname +
                ", courseid = " + courseid +
                ", coursename = " + coursename +
                ", grade = " + grade +
                ", score = " + score
        );
	}
}
