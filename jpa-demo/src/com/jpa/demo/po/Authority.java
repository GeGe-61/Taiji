package com.jpa.demo.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authority")
public class Authority {
	public Authority(String name) {
		super();
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="a_id")
	private int id;
	@Column(name="name")
	private String name;
	@ManyToMany(mappedBy="authorities")
	private List<User> users;
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
	public Authority(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Authority() {
		super();
	}
	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + "]";
	}
	

}
