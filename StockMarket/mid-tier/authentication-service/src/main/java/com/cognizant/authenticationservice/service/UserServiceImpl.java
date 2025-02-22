package com.cognizant.authenticationservice.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.authenticationservice.entity.ConfirmationToken;
import com.cognizant.authenticationservice.entity.Role;
import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.authenticationservice.repository.ConfirmationTokenRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	
	
	@Transactional
	public User getByUsername(String name) {
		LOGGER.info("User->getByUsername() has started and ended");
		return userRepository.findByUsername(name);
	}
	
	@Transactional
	public User signup(User user) throws UserAlreadyExistException {
		
		LOGGER.info("User->signUp(user) has started");		
		if(userRepository.findByUsername(user.getUsername()) == null) {
			LOGGER.info("User->signUp USER is NOT EXIST");
			LOGGER.info("User->signUp() USER is CREATING");
			User newUser = new User();
			newUser.setUsername(user.getUsername());
			newUser.setEmailid(user.getEmailid());
			newUser.setContactNumber((user.getContactNumber()));
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			Set<Role> userRole = new HashSet<Role>();
			Role role = roleRepository.findByName("ROLE_USER");
			userRole.add(role);
			newUser.setUserRole(userRole);
			newUser.setConfirmed(false);
			LOGGER.debug("NEW USER DETAILS: {}", newUser);
			
			
			ConfirmationToken confirmationToken = new ConfirmationToken(newUser);
            

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(newUser.getEmailid());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("examplenikilesh@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8083/authentication-service/stockmarket/confirmation/" + confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
            confirmationTokenRepository.save(confirmationToken);
            userRepository.save(newUser);
            return newUser;
		}
		else {
			LOGGER.info("User->signUp() USER EXIST THROWING EXCEPTION");
			throw new UserAlreadyExistException("User Already Exist");
		}
	}
	
	@Transactional
	public User updateUser(User user) {
		User updateUser = userRepository.findByUsername(user.getUsername());
		updateUser.setContactNumber(user.getContactNumber());
		updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(updateUser);
	}

}
