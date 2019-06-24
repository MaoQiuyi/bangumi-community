package com.project.bangumi_community.domain.base;

public class Character extends BaseInfo {
	private String gender;
	private String birth;
	private String death;
	private String nationality;
	private String nation;
	private String height;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDeath() {
		return death;
	}
	public void setDeath(String death) {
		this.death = death;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Character [" + super.toString() + ", "
				+ "gender=" + gender + ", birth=" + birth + ", death=" + death + ", nationality=" + nationality
				+ ", nation=" + nation + ", height=" + height
				+ "]";
	}
}
