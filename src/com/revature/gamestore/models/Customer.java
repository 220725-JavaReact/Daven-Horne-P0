package com.revature.gamestore.models;

public class Customer {
 private int CustomerId;
private String firstName;
private String lastName;
private String address;
private String email;
private int age;
private String password;
 
 public int getCustomerId() {
	return CustomerId;
}
public void setCustomerId(int customerId) {
	this.CustomerId = customerId;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getName() {
	return getFirstName()+","+getLastName();
}
public void setName(String name) {
	name = getFirstName()+","+getLastName();
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 public String setAddress(String address) {
	 return this.address = address;
 } 
public String getAddress() {
	 return address;
}

public Customer(int customerId, String name, int age, String email, String address) {
	super();
	CustomerId = customerId;
	name = getFirstName()+","+getLastName();
	this.age = age;
	this.email = email;
	this.address = address;
}

public Customer(int id, String fName, String lName, int age, String email, String password, String address) {
	super();
	this.CustomerId = id;
	this.firstName = fName;
	this.lastName = lName;
	this.age = age;
	this.email = email;
	this.address = address;
	this.password = password;
}
public Customer( String fName, String lName, int age, String email, String password, String address) {
	super();
	this.firstName = fName;
	this.lastName = lName;
	this.age = age;
	this.email = email;
	this.address = address;
	this.password = password;
}
@Override
public String toString() {
	return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email=" + email
			+ ", age=" + age + ", password=" + password + "]";
}

}
