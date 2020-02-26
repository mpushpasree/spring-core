package com.cts.swrbd.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.swrbd.model.AppUserEntity;
import com.cts.swrbd.model.AppUserModel;
import com.cts.swrbd.dao.AppUserEntityRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserEntityRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	//PASSWORDS CAN'T BE RETRIVED THEY CAN BE ONLY CHANGED.
	
	//ENTITY WILL HAVE ENCRYPTED PASSWORD
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUserEntity user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(),		//PASSWORD IS IN ENCRYPTED FORM
				new ArrayList<>());   //SET OF ROLES IN WITCH THE USER IS THERE  [this can be modified in our project]
	}
	
	public AppUserEntity save(AppUserModel userDTO) {
		AppUserEntity user = new AppUserEntity();
		user.setUsername(userDTO.getUsername());
		user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userDao.save(user);
	}

}