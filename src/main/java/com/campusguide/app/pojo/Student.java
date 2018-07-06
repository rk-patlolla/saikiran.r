package com.campusguide.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private int sId;
	@NotBlank
	@Column(name = "student_name", length = 45)
	private String studentName;
	@NotBlank
	@Column(name = "student_type", length = 45)
	private String studenType;

	@NotBlank
	@Column(name = "mobile_no", length = 45)
	private String mobileNo;
	@NotBlank
	@Column(name = "s_status", length = 45)
	private int sStatus;

	/* To_String */
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", studentName=" + studentName + ", studenType=" + studenType + ", mobileNo=" + mobileNo + ", sStatus=" + sStatus + "]";
	}
	

	/* Getter and Setters */
	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudenType() {
		return studenType;
	}


	public void setStudenType(String studenType) {
		this.studenType = studenType;
	}





	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}





	public int getsStatus() {
		return sStatus;
	}


	public void setsStatus(int sStatus) {
		this.sStatus = sStatus;
	}

	/* DefaultConstructor */
	public Student() {
		// TODO Auto-generated constructor stub
	}



}
