package com.app.pojos;



import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {
	
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="User_Id")
private long userId;

@Column(name="Full_Name",length = 255,nullable=false)
private String name;

@Column(name="User_Name",length = 50,nullable=false,unique = true)
private String userName;

@Column(name="Password",length = 255,nullable=false)
private String password;

@Column(name="Phone_Num")
private String phoneNum;

@Column(name="role")
private String role;

@Transient
private String confirmPassword;



public long getUserId() {

	return userId;
}
public void setUserId(long userId) {

	this.userId = userId;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
