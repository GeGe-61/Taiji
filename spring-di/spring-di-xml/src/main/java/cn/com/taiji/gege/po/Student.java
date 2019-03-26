package cn.com.taiji.gege.po;


public class Student {
	private int stuId;
    private String stuName;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Student(int stuId, String stuName) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
	}
	public Student() {
		super();
	}
	public void init() {
		System.out.println("init");
	}
	public void stop() {
		System.out.println("stop");
	}
}
