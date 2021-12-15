
package com.IMS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Exam {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String module;
	
	private String batch;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date examination_date;
	
	@ManyToOne
	
		
    public Integer getId() {
        return id;
    }
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBatch() {
		return batch;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	public Date getExamination_date() {
		return examination_date;
	}

	public void setExamination_date(Date examination_date) {
		this.examination_date =examination_date;
	}

	
}
