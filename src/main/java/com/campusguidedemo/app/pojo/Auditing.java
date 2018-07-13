package com.campusguidedemo.app.pojo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;





public class Auditing {
	@CreatedDate
	
	private Date created_date;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updated_date;
	

}
