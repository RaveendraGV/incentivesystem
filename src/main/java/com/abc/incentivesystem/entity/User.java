package com.abc.incentivesystem.entity;



import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name = "user_tbl")
public class User {



@Id
@Column(name = "user_id")
private long id;



@NotNull(message = "Please provide a name")
@Column(name = "username")
private String userName;



@NotNull(message = "Please provide a password")
@Column(name = "password", nullable = false)
private String passWord;



@Column(name = "role")
private String role;

@JsonIgnore
@OneToMany(targetEntity = Booking.class, mappedBy = "user", cascade = CascadeType.ALL)
private List<Booking> booking;

@JsonIgnore
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Incentive> incentive;



public long getId() {
return id;
}



public void setId(long id) {
this.id = id;
}



public String getUsername() {
return userName;
}



public void setUsername(String username) {
this.userName = username;
}



public String getPassword() {
return passWord;
}



public void setPassword(String password) {
this.passWord = password;
}



public String getRole() {
return role;
}



public void setRole(String role) {
this.role = role;
}



public List<Booking> getBooking() {
return booking;
}



public void setBooking(List<Booking> booking) {
this.booking = booking;
}



public List<Incentive> getIncentive() {
return incentive;
}



public void setIncentive(List<Incentive> incentive) {
this.incentive = incentive;
}




}
