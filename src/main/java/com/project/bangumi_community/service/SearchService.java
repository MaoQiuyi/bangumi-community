package com.project.bangumi_community.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.domain.base.BaseInfo;
import com.project.bangumi_community.repository.AnimeCharacterMapper;
import com.project.bangumi_community.repository.AnimeMapper;
import com.project.bangumi_community.repository.VoiceActorMapper;

@Component
public class SearchService {
	@Autowired
	AnimeMapper am;
	@Autowired
	AnimeCharacterMapper acm;
	@Autowired
	VoiceActorMapper vam;
	
	public List<Object> searchAllByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		List<Anime> aList = am.getAnimeByKeyword(keyword);
		List<AnimeCharacter> acList = acm.getAnimeCharacterByKeyword(keyword);
		List<VoiceActor> vaList = vam.getVoiceActorByKeyword(keyword);
		List<Object> base = new ArrayList<Object>();
		
		for(Anime a : aList) {
			a.setType("anime");
			base.add(a);
		}
			
		for(AnimeCharacter ac : acList) {
			ac.setType("anime_character");
			base.add(ac);
		}
			
		for(VoiceActor va : vaList) {
			va.setType("voice_actor");
			base.add(va);
		}
		return base;
	}
}
