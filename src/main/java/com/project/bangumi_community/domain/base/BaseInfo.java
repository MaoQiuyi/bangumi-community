package com.project.bangumi_community.domain.base;

public class BaseInfo {
	private String id;
	private String nameChinese;
	private String nameForeign;
	private String nameNick;
	private String information;
	private String type;
	private String cover;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameChinese() {
		return nameChinese;
	}
	public void setNameChinese(String nameChinese) {
		this.nameChinese = nameChinese;
	}
	public String getNameForeign() {
		return nameForeign;
	}
	public void setNameForeign(String nameForeign) {
		this.nameForeign = nameForeign;
	}
	public String getNameNick() {
		return nameNick;
	}
	public void setNameNick(String nameNick) {
		this.nameNick = nameNick;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "BaseInfo [id=" + id + ", nameChinese=" + nameChinese + ", nameForeign=" + nameForeign + ", nameNick="
				+ nameNick + ", information=" + information + "]";
	}
}
