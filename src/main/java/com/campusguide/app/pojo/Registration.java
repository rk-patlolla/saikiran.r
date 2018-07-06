/*package com.campusguide.app.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Table(name="registration")

public class Registration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Long uId;
 
	@NotBlank
	@Column(name = "user_name", length = 45)
	private String userName;
	
	@NotBlank
	@Email
	@Column(name = "user_email", length = 45)
	private String userEmail;
	
	@NotBlank
	@Column(name = "user_password", length = 45)
	private String userPassword;
	@NotBlank
	@Column(name = "user_type", length = 45)
	private String userType;
	
	@NotBlank
	@Column(name = "r_status", length = 45)
	private int rStatus;
	
	
	
	
	if going for Constructor injection use this
	
	public Registration(int u_id, String user_name, String user_email, String user_password, String status) {
		super();
		this.u_id = u_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.status = status;
	}
	
	
	to_string method
	
	@Override
	public String toString() {
		return "Registration [u_id=" + u_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", r_status=" + r_status + "]";
	}
	
	 Setter && Getter injection
	

	public int getU_id() {
		return u_id;
	}
	
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

     public int getR_status() {
		return r_status;
	}
	public void setR_status(int r_status) {
		this.r_status = r_status;
	}
	
	
	
	
	DelfaultCOnstructor
	public Registration() {
	
		// TODO Auto-generated constructor stub
	}

	
	
	
}
*/