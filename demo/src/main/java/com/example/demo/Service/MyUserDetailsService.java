package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MyUserDetails;
import com.example.demo.Model.UserEntity;
import com.example.demo.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserEntity> userEntity = userRepository.findByUserName(userName);

		userEntity.orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
		
		return userEntity.map(MyUserDetails::new).get();
	}

}
