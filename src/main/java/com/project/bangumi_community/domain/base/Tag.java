package com.project.bangumi_community.domain.base;

public class Tag {
	private String id;
	private String name;
	private String information;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", information=" + information + "]";
	}
}
