package com.app.NeptuneDemo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long userId;
	@Column(nullable = false, length = 255)
	private String firstName;
	@Column(length = 255)
	private String lastName;
	@Column(nullable = false, length = 255, unique = true)
	@NotEmpty
	@Email(message = "{errors.invalid_email}")
	private String email;
	@NotEmpty
	private String password;
	private String address;
	private Integer phoneNumber;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
					inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "role_id")}
			
			)
	private List<Role> roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Long userId, String firstName, String lastName,
			@NotEmpty @Email(message = "{errors.invalid_email}") String email, @NotEmpty String password,
			String address, Integer phoneNumber, List<Role> roles) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
	}

	public User(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getLastName();
		this.password = user.getPassword();
		this.address =  user.getAddress();
		this.phoneNumber = user.getPhoneNumber();
		this.roles = user.getRoles();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
