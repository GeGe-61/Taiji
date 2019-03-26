package cn.com.taiji.gege.po;

public class User {
	private String uname;
	private int uage;
	private Student stu;
	private Teacher teacher;
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public User(String uname, int uage) {
		super();
		this.uname = uname;
		this.uage = uage;
	}
	public User() {
		super();
	}
	public User(String uname, int uage, Student stu, Teacher teacher) {
		super();
		this.uname = uname;
		this.uage = uage;
		this.stu = stu;
		this.teacher = teacher;
	}

}
