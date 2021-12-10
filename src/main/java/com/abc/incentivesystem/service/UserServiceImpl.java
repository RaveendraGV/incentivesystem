package com.abc.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.incentivesystem.dao.IUserDao;
import com.abc.incentivesystem.entity.User;
import com.abc.incentivesystem.exception.AuthenticationFailureException;
import com.abc.incentivesystem.exception.DuplicateIdException;
import com.abc.incentivesystem.exception.InvalidIdException;
import com.abc.incentivesystem.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private IUserDao userDao;

	final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		Optional<User> optionalUser = userDao.findById(user.getId());
		if (optionalUser.isPresent()) {
			throw new DuplicateIdException("User Id " + user.getId() + " already exist");
		}
		User newUser = userDao.save(user);
		logger.info("User added sucessfully!!");
		return newUser;
	}

	@Override
	public User changePassword(User user, long id) throws ResourceNotFoundException {
		Optional<User> optionalUser = userDao.findById(user.getId());
		if (optionalUser.isEmpty()) {
			throw new ResourceNotFoundException("Record not found with id : " + user.getId());
		}

		User userUpdate = userDao.getById(id);
		userUpdate.setPassword(user.getPassword());
		userDao.save(userUpdate);
		return userUpdate;

	}

	@Override
	public User deleteUser(long id) throws InvalidIdException {
		Optional<User> optionalUser = userDao.getUserByID(id);
		if (optionalUser.isEmpty()) {
			throw new InvalidIdException("User doesn't exist with the given id :" + " " + id);
		}
		User user = userDao.findById(id).get();
		userDao.delete(user);
		return user;

	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public User login(String userName, String password) {
		Optional<User> optioanlUser = userDao.doLogin(userName, password);
		if (optioanlUser.isEmpty()) {
			throw new AuthenticationFailureException("Username or Password is Wrong");
		}
		User newUser = optioanlUser.get();
		return newUser;

	}

}