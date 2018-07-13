package com.campusguidedemo.app.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "course", uniqueConstraints = { @UniqueConstraint(columnNames = { "course_name", "course_type" }) })
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1314506204182209359L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private Long cId;
	@NotBlank
	@Column(name = "course_name", length = 45, unique = true)
	private String courseName;
	@NotBlank
	@Column(name = "course_type", length = 45)
	private String courseType;
	@NotBlank
	@Column(name = "course_description", length = 45)
	private String courseDescription;
	@Column(name = "c_status", length = 10)
	private int cStatus = 0;

	@Column(name = "created_date", updatable = false)
	private Date createdDate;

	@Column(name = "update_date")
	private Date updatedDate;

	/* Setter && Getters */

	public Course() {
		// TODO Auto-generated constructor stub
	}

	/* To String */

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getcStatus() {
		return cStatus;
	}

	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", courseName=" + courseName + ", courseType=" + courseType
				+ ", courseDescription=" + courseDescription + ", cStatus=" + cStatus + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
