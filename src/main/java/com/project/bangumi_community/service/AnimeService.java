package com.project.bangumi_community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.AnimeTag;
import com.project.bangumi_community.repository.AnimeCharacterMapper;
import com.project.bangumi_community.repository.AnimeMapper;
import com.project.bangumi_community.repository.TagMapper;

@Component
public class AnimeService {
	@Autowired
	AnimeMapper animeMapper;
	@Autowired
	AnimeCharacterMapper animeCharacterMapper;
	@Autowired
	TagMapper tagMapper;
	
	public List<Anime> getAllAnime() {
		return animeMapper.getAllAnime();
	}
	
	public Anime getAnimeByAnimeId(String id) {
		Anime anime = animeMapper.getAnimeByAnimeId(id);
		return anime;
	}
	
	public List<Anime> getAnimeByAnimeName(String name) {
		name = "%" + name + "%";
		List<Anime> animeList = animeMapper.getAnimeByAnimeName(name);
		return animeList;
	}
	
	public void addAnime(Anime anime) {
		//是否已经存在   存在则false
		Anime oldAnime = animeMapper.getAnimeByAnimeId(anime.getId());
		if(oldAnime != null)
			animeMapper.updateAnime(anime);
		else
			animeMapper.addAnime(anime);
		/*
		//Anime中的一对多和多对多关系
		List<AnimeCharacter> allAnimeCharacterId = animeCharacterMapper.getAllAnimeCharacterId();
		List<AnimeCharacter> testedAnimeCharacter = anime.getAnimeCharacter();
		List<AnimeCharacter> needToAdd = new ArrayList<AnimeCharacter>();
		
		
		for(AnimeCharacter a : testedAnimeCharacter) {
			boolean isHave = false;
			for(AnimeCharacter ac : allAnimeCharacterId) {
				if(ac.getId().equals(a.getId())) {
					isHave = true;
					break;
				}
			}
			if(!isHave) 
				needToAdd.add(a);
		}
		if(needToAdd.size() != 0) {
			for(AnimeCharacter ac : needToAdd) {
				animeCharacterMapper.addAnimeCharacter(ac);
			}
		}

		for(int i = 0; i < testedAnimeCharacter.size(); i++) {
			animeMapper.addAnimeToAnimeCharacter(anime.getId(), testedAnimeCharacter.get(i).getId());
		}
		*/
	}

	public void updateTag(String id, String tagStr) {
		animeMapper.deleteTag(id);
		if(tagStr.isEmpty())
			return;
		String[] tagStrArr = tagStr.split("、");
		for(String tagName : tagStrArr) {
			AnimeTag tag = tagMapper.getAnimeTagByName(tagName);
			animeMapper.addAnimeTag(id, tag.getId());
		}
	}

	public void updataAnimeCharacter(String id, String animeCharacterStr) {
		// TODO Auto-generated method stub
		animeMapper.deleteAnimeCharacter(id);
		if(animeCharacterStr.isEmpty())
			return;
		String[] animeCharacterStrArr = animeCharacterStr.split("、");
		for(String animeCharacterName : animeCharacterStrArr) {
			AnimeCharacter animeCharacter = animeCharacterMapper.getAnimeCharacterByNameChinese(animeCharacterName);
			if(animeCharacter == null)
				return;
			animeMapper.addAnimeCharacter(id, animeCharacter.getId());
		}
	}
}
