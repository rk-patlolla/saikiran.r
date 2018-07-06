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
	private Long sId;
	@NotBlank
	@Column(name = "student_name", length = 45)
	private String studentName;
	@NotBlank
	@Column(name = "student_type", length = 45)
	private String studentType;
	
/*	@Column(name = "u_id")
    private Long uId=0L;*/
	@NotBlank
	@Column(name = "mobile_no", length = 45)
	private String mobileNo;
	
	@Column(name = "s_status", length =10)
	private int sStatus=0;

	/* To_String */
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", studentName=" + studentName + ", studenType=" + studentType 
				+ ", mobileNo=" + mobileNo + ", sStatus=" + sStatus + "]";
	}

	/* Getter and Setters */
	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studenType) {
		this.studentType = studenType;
	}

/*	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}
*/
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
