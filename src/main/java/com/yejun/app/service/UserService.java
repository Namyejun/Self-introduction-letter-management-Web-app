package com.yejun.app.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yejun.app.domain.OAuthType;
import com.yejun.app.domain.User;
import com.yejun.app.persistence.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void insertUser(User user) {
		if(user.getOauth() == null) {
			user.setOauth(OAuthType.DEFAULT);
		}
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User getUser(String userId) {
		User findUser =  userRepository.findByUserId(userId).orElseGet(() -> {
			return new User();
		});
		return findUser;
	}
	
	@Transactional
	public User updateUser(User user, OAuthType oauth) {
		User findUser = userRepository.findById(user.getId()).get();
		findUser.setName(user.getName());
		findUser.setUserId(user.getUserId());
		if (oauth == OAuthType.DEFAULT) {
			findUser.setPw(user.getPw());
		}
		findUser.setEmail(user.getEmail());
		
		return findUser;
	}
	
	@Transactional
	public void deleteUser(User user) {
		userRepository.deleteById(user.getId());
	}
}
