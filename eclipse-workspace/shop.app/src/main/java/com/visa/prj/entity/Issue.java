package com.visa.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issues")
public class Issue {
	@Id
	private int id;
	private String description;
	@Column(name="raised_by")
	private String raisedBy;
	@Column(name="raised_date")
	private String raisedDate;
	@Column(name="resolved_by")
	private String resolvedBy;
	@Column(name="resolved_date")
	private String resolvedDate;
	private String solution;
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public String getRaisedDate() {
		return raisedDate;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public String getSolution() {
		return solution;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	

}
