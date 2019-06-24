package com.project.bangumi_community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.repository.AnimeCharacterMapper;
import com.project.bangumi_community.repository.VoiceActorMapper;

@Component
public class AnimeCharacterService {
	@Autowired
	AnimeCharacterMapper acm;
	@Autowired
	VoiceActorMapper vam;
	
	public void addAnimeCharacter(AnimeCharacter ac) {
		AnimeCharacter searchedAc = acm.getAnimeCharacterById(ac.getId());
		if(searchedAc == null)
			acm.addAnimeCharacter(ac);
		else
			acm.updateAnimeCharacter(ac);
	}

	public void updateAnimeCharacter(AnimeCharacter ac) {
		AnimeCharacter searchedAc = acm.getAnimeCharacterById(ac.getId());
		if(searchedAc == null)
			acm.addAnimeCharacter(ac);
		else
			acm.updateAnimeCharacter(ac);
	}

	
	public void updateVoiceActor(String id, String voiceActorStr) {
		String[] voiceActorStrArr = voiceActorStr.split("、");
		//删除原有关联
		acm.deleteVoiceActor(id);
		
		if(voiceActorStr.isEmpty())
			return;
		
		//添加现在的关联
		for(String s : voiceActorStrArr) {
			VoiceActor va = vam.getVoiceActorByNameChinese(s);
			acm.addVoiceActor(id, va.getId());
		}
	}

	public AnimeCharacter getAnimeCharacterById(String id) {
		AnimeCharacter animeCharacter = acm.getAnimeCharacterById(id);
		return animeCharacter;
	}

	public List<AnimeCharacter> getAllAnimeCharacter() {
		List<AnimeCharacter> animeCharacterList = acm.getAllAnimeCharacter();
		return animeCharacterList;
	}
}
