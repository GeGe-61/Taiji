package com.taiji.ge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.ge.domain.User;
import com.taiji.ge.domain.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public User saveUser(User user) {
		
		return userRepository.saveAndFlush(user);
	}
	//login查询验证
	public User findOneUser(User user) {
		
		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
	//get全部user
    public List<User> findAllUser() {
		
		return userRepository.findAll();
	}

}
