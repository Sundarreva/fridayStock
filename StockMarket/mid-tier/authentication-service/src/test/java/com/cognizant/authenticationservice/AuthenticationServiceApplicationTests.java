package com.cognizant.authenticationservice;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognizant.authenticationservice.entity.ConfirmationToken;
import com.cognizant.authenticationservice.entity.Role;
import com.cognizant.authenticationservice.entity.User;
import com.cognizant.authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.authenticationservice.repository.ConfirmationTokenRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.service.ConfirmationTokenService;
import com.cognizant.authenticationservice.service.EmailSenderService;
import com.cognizant.authenticationservice.service.UserServiceImpl;

@SpringBootTest
class AuthenticationServiceApplicationTests {

//	@MockBean
//	UserRepository userRepository;
//	
//	@MockBean
//	RoleRepository roleRepository;
//	
//	@MockBean
//	ConfirmationTokenRepository confirmationTokenRepository;
//	
//	@Autowired
//	EmailSenderService emailSenderService;
//	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	ConfirmationTokenService confirmationTokenService;
//	
//	@Autowired
//	AppUserDetailsService appUserDetailsService; 
//	
//	@Test 
//	public void testSignupUser() {
//		User user = createUser();
//		Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
//		assertAll(() -> userService.signup(user));
//	}
//	
//	@Test 
//	public void testSignupExistUser() {
//		User user = createUser();
//		Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
//		Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
//		Exception exception = assertThrows(UserAlreadyExistException.class, ()-> userService.signup(user));
//		assertTrue("User Already Exist".contains(exception.getMessage()));
//	}
//	
//	@Test
//	public void testFindbyName() {
//		User user = createUser();
//		Mockito.when(userService.getByUsername(user.getUsername())).thenReturn(user);
//		assertEquals(user,userService.getByUsername(user.getUsername()));
//	}
//	
//	@Test
//	public void testtokenservice() {
//		String token = "123";
//		ConfirmationToken conf = new ConfirmationToken();
//		conf.setConfirmationToken(token);
//		conf.setCreatedDate(new Date());
//		conf.setUser(createUser());
//		conf.setTokenid(1);
//		User user = createUser();
//		Mockito.when(confirmationTokenRepository.findByConfirmationToken(token)).thenReturn(conf);
//		Mockito.when(userService.getByUsername(user.getUsername())).thenReturn(user);
//		assertEquals(null , confirmationTokenService.confirmMailAddress(token));
//	}
//	
//	@Test
//	public void testUpdateUser() {
//		User user = createUser();
//		Mockito.when(userService.getByUsername(user.getUsername())).thenReturn(user);
//		assertNotEquals(user,userService.updateUser(user));
//		
//	}
//	
//	@Test
//	public void appUserDetailsService() {
//		User user = createUser();
//		Mockito.when(userService.getByUsername(user.getUsername())).thenReturn(null);
//		Exception exception = assertThrows(UsernameNotFoundException.class, () -> appUserDetailsService.loadUserByUsername(user.getUsername()));
//		assertEquals(exception.getMessage(),"user");
//	}
//	
//	@Test
//	public void appUserDetailsServicewithnull() {
//		User user = createUser();
//		Mockito.when(userService.getByUsername(user.getUsername())).thenReturn(user);
//		assertAll(() ->appUserDetailsService.loadUserByUsername(user.getUsername()));
//	}
//	
//
//	
//	public User createUser() {
//		
//		User user = new User();
//		user.setUsername("user");
//		user.setEmailid("mailid@mail.com");
//		user.setContactNumber("939393939");
//		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
//		Set<Role> userRole = new HashSet<Role>();
//		Role role = roleRepository.findByName("ROLE_USER");
//		userRole.add(role);
//		user.setUserRole(userRole);
//		user.setConfirmed(false);
//		
//		return user;
//		
//	}
	
	

}
