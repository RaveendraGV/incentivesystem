package com.abc.incentivesystem.dao;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.abc.incentivesystem.entity.User;

public interface IUserDao extends JpaRepository<User, Long> {

//	@Query("select a from User a where a.userName = :uname and a.password = :pwd")
//	public Optional<User> doLogin(@Param("uname") String UserName, @Param("pwd") String password);
//
//	@Query(value = "select a from User a where a.id= :id")
//	public Optional<User> getUserByID(@Param("id") long id);

}
