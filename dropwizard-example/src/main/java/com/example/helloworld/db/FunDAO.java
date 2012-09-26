package com.example.helloworld.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Fun")
public class FunDAO {
	
	public String model; // eg. "DVF1"
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
	    return id;
	}
	
	public FunDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public FunDAO(String model) {
		this.model = model;
	}
	
	public Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
}
