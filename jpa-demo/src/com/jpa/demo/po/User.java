package com.jpa.demo.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tuser")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int tuid;
	@Column(name="username")
	private String username;
	public User(int tuid, List<Photo> photos) {
		super();
		this.tuid = tuid;
		this.photos = photos;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	@Column(name="password")
	private String password;
	@ManyToMany
	@JoinTable(name="user_authority",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="authority_id"))
	private List<Authority> authorities;
	@OneToMany(mappedBy="user")
	private List<Photo> photos;
	public int getTuid() {
		return tuid;
	}
	public void setTuid(int tuid) {
		this.tuid = tuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int tuid, String username, String password) {
		super();
		this.tuid = tuid;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [tuid=" + tuid + ", username=" + username + ", password=" + password + "]";
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(List<Photo> photos) {
		super();
		this.photos = photos;
	}
	public User(String username, String password, List<Authority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}
