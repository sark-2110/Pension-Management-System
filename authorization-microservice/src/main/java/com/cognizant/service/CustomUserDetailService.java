package com.cognizant.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.exception.ResourceNotFound;
import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);

	private UserRepository userRepository;

	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/*loadbyUserName function loads user from the repository 
	 * returns UserDetails 
	 */

	
	//loading user name from user database passing to spring provided UserDetails  
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
		LOGGER.info("STARTED - loadUserByUsername");
		User user = userRepository.findByUserName(username);
		LOGGER.info("END - loadUserByUsername");
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
		
		}catch(Exception e)
		{
			LOGGER.error("ERROR-username not found");
			throw new ResourceNotFound("User by the given username not found");
		}
		
	}

}
