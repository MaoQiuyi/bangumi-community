package com.project.bangumi_community.domain;

import java.util.List;

import com.project.bangumi_community.domain.base.BaseInfo;

public class Anime extends BaseInfo {
	private List<AnimeCharacter> animeCharacter;
	private List<AnimeTag> animeTag;
	
	public List<AnimeCharacter> getAnimeCharacter() {
		return animeCharacter;
	}
	public void setAnimeCharacter(List<AnimeCharacter> animeCharacter) {
		this.animeCharacter = animeCharacter;
	}
	public List<AnimeTag> getAnimeTag() {
		return animeTag;
	}
	public void setAnimeTag(List<AnimeTag> animeTag) {
		this.animeTag = animeTag;
	}
	
}
