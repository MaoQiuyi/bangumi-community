package com.project.bangumi_community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.domain.AnimeTag;
import com.project.bangumi_community.repository.TagMapper;

@Component
public class TagService {
	@Autowired
	TagMapper tm;
	
	public void addAnimeTag(AnimeTag animeTag) {
		AnimeTag at = tm.getAnimeTagById(animeTag.getId());
		if(at == null) 
			tm.addAnimeTag(animeTag);
		else
			tm.updateAnimeTag(animeTag);
	}
	
	public void updateAnimeTag(AnimeTag animeTag) {
		tm.updateAnimeTag(animeTag);
	}

	public AnimeTag getAnimeTagById(String id) {
		AnimeTag animeTag = tm.getAnimeTagById(id);
		return animeTag;
	}
}
