package com.lcwd.user.sevice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.sevice.entities.User;
import com.lcwd.user.sevice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserService userService;
	
	int count = 1;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping("/{userId}")
//	@CircuitBreaker(name ="ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
//	@Retry(name="ratingHotelRetry", fallbackMethod = "ratingHotelFallBack")
	@RateLimiter(name="ratingHotelRateLimitor", fallbackMethod = "ratingHotelFallBack")

	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Retry count : {}",count);
		count++;
		
		User user = userService.getUser(userId);
		
		
		
		return ResponseEntity.ok(user);
	}
	
	
	//Creating fallback method for circuit breaker
	
	public  ResponseEntity<User>  ratingHotelFallBack(String userId, Exception ex){
		logger.info("fallback method excuted because sevice is down: ", ex.getMessage());
		
		User user = User.builder().email("dummyEMail").name("name").about("This user is created because some service is down")
		.userId("12334").build();
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		
		return ResponseEntity.ok(allUser);
	}

}
