package com.asmaa.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.JoinColumn;
import com.asmaa.validation.user.PasswordsEqualConstraint;
@Entity
@Table(name = "users")
@PasswordsEqualConstraint(message = "passwords are not equal")
public class User  implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="userName")
	@Size(min = 5, message = "Enter atleast 5 Characters.")
	@NotEmpty
	private String userName;
@Email
private String email;
	@Column(name="password")
	@Size(min = 5, message = "Enter atleast 5 Characters.")
	private String password;
	
	@Transient
	private String confirmpassword;
	
	@ManyToMany(fetch = FetchType.EAGER)// may users can have many roles
	@JoinTable(name="usersandroles",
	joinColumns=@JoinColumn(name="user_Id"),
	inverseJoinColumns=@JoinColumn(name="role_Id"))
    private List<Role> roles;
    private String status;
	public User() {
		super();
	}
	public User(int id, String userName,String email, String password, List<Role> roles, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.email=email;
		this.password = password;
		this.roles = roles;
		this.status = status;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
