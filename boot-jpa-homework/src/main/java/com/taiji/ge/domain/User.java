package com.taiji.ge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tuser")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tuid")
	private int tuid;
	@NotEmpty
	@Column(name="username",length=1000,nullable=false)
    private String username;
	@Email
	@Column(name="email",unique=true,length=1000,nullable=false)
	private String email;
	@NotEmpty
	@Size(min=6)
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="gender")
	private int gender;
//	@Column(name="utime",nullable=false)
//	private Data utime;

}
