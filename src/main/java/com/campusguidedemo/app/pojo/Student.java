package com.campusguidedemo.app.pojo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Long sId;
	@Pattern(regexp = "^[a-zA-Z.\\-\\/+=@_ ]*$")
	@NotBlank
	@Column(name = "student_name", length = 45)
	private String studentName;
	@NotBlank
	@Column(name = "student_type", length = 45)
	private String studentType;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "c_id")
	private Course course;

	@NotBlank
	@Length(min = 10, max = 10, message = "Mobile number be  10 digits")
	@Column(name = "mobile_no",unique=true)
	private String mobileNo;

	@NotBlank
	@Column(name = "student_password")
	private String studentpassword;
	@NotBlank
	@Column(name = "student_role", length = 45)
	private String userrole="ROLE_USER";

	@Column(name = "s_status", length = 10)
	private int sStatus = 0;
    @CreatedDate
	@Column(name = "created_date", updatable = false)
	private Date created;
    @LastModifiedDate
	@Column(name = "updated_date")
	private Date updated;
	
	@CreatedBy
	@Column(name="created_by")
	private String createdBy;
	
	@LastModifiedBy
	@Column(name="modified_by")
	private String modifiedBy;


	/* DefaultConstructor */
	public Student() {
		// TODO Auto-generated constructor stub
	}



	/* Getter and Setters */
	public Date getCreated() {
		return created;
	}





	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

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

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", studentName=" + studentName + ", studentType=" + studentType + ", course="
				+ course + ", mobileNo=" + mobileNo + ", studentpassword=" + studentpassword + ", userrole=" + userrole
				+ ", sStatus=" + sStatus + ", created=" + created + ", updated=" + updated + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + "]";
	}

}
