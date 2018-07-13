package com.campusguidedemo.app.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student_course_master_t")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sc_id")
	private long scId;
	@NotBlank
	@Column(name = "s_id")
	private long sId;
	@NotBlank
	@Column(name = "c_id")
	private long cId;
	@NotBlank
	@Column(name = "sc_Status")
	private long scStatus;

	@Column(name = "created_date")
	private Date created;

	public long getScId() {
		return scId;
	}

	public void setScId(long scId) {
		this.scId = scId;
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public long getScStatus() {
		return scStatus;
	}

	public void setScStatus(long scStatus) {
		this.scStatus = scStatus;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public StudentCourse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentCourse [scId=" + scId + ", sId=" + sId + ", cId=" + cId + ", scStatus=" + scStatus + ", created="
				+ created + "]";
	}

}
