package com.jpa.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Photo")
public class Photo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	
	@Column(name="pname",nullable = false, length = 200, unique = true)
	private String pname;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Photo(String pname) {
		super();
		this.pname = pname;
	}
	public Photo(String pname, User user) {
		super();
		this.pname = pname;
		this.user = user;
	}
	public Photo() {
		super();
	}
	public Photo(int pid, String pname, User user) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.user = user;
	}
	
	
}
