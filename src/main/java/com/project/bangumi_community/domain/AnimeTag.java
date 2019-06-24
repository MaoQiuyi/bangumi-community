package com.project.bangumi_community.domain;

import java.util.List;

import com.project.bangumi_community.domain.base.Tag;

public class AnimeTag extends Tag{

	List<Anime> anime;
	public List<Anime> getAnime() {
		return anime;
	}

	public void setAnime(List<Anime> anime) {
		this.anime = anime;
	}

	@Override
	public String toString() {
		return "AnimeTag [toString()=" + super.toString() + "]";
	}
}
