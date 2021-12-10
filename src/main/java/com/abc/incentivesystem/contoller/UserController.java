package com.abc.incentivesystem.contoller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abc.incentivesystem.entity.User;
//import com.abc.incentivesystem.payload.LoginReqPayLoad;
import com.abc.incentivesystem.service.UserService;

@RestController
@RequestMapping("/incentivesys")
public class UserController {
	@Autowired
	private UserService userService;
	final Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/register")
	public ResponseEntity<User> registerNewUser(@Valid @RequestBody User user) {
		User user1 = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user1, HttpStatus.CREATED);
		return responseEntity;
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable("id") long id) {
		User user = userService.deleteUser(id);
		logger.info("User deleted sucessfully!!");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @Valid @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(this.userService.changePassword(user, id));
	}

//	@PostMapping("/login")
//	public ResponseEntity<User> doLogin(@Valid @RequestBody LoginReqPayLoad loginUser) {
//		User user = userService.login(loginUser.getUserName(), loginUser.getPassword());
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}

	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
