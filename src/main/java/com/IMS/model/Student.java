package com.IMS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String index_no;
	
	private String name;
	
	private String batch;
	
	private String module;
	
	private String result;
	
	@ManyToOne
	
		
    public Integer getId() {
        return id;
    }
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIndex_no() {
		return index_no;
	}

	public void setIndex_no(String index_no) {
		this.index_no = index_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
}
