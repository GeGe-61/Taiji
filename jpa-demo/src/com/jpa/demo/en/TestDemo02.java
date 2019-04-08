package com.jpa.demo.en;



import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.jpa.demo.po.Authority;
import com.jpa.demo.po.Photo;
import com.jpa.demo.po.User;


public class TestDemo02 {
	@PersistenceContext
	EntityManager eManager;
	
	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpa-demo");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
//	addUser(entityManager,"u2","123");
//	addAuthority(entityManager,"a2");
	//ManyToMany
//	addUserAndAuthority(entityManager,1);
	//oneToMany
	addPhoto(entityManager, "xiaohua");
	
	entityTransaction.commit();
	entityManager.close();
	entityManagerFactory.close();
	}
	
	private static void addUser(EntityManager entityManager,String username,String password) {
		
		User user=new User(username, password);
		entityManager.persist(user);
    }
	
	private static void addAuthority(EntityManager entityManager,String name) {
		
		Authority authority=new Authority(name);
		entityManager.persist(authority);
    }
	
	private static void addUserAndAuthority(EntityManager entityManager,int id) {

		List<Authority> authorities=entityManager.createQuery("select a from Authority a").getResultList();
		User user=entityManager.find(User.class, id);
		user.setAuthorities(authorities);
		entityManager.persist(user);
	}

	
	private static void addPhoto(EntityManager entityManager,String name) {
		User user=entityManager.find(User.class, 1);
		Photo photo=new Photo();
		photo.setPname(name);
		photo.setUser(user);
		entityManager.persist(photo);
	}

}
