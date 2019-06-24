package com.project.bangumi_community.domain;

import java.util.List;

import com.project.bangumi_community.domain.base.Character;

public class VoiceActor extends Character {
	private List<AnimeCharacter> animeCharacter;
	
	public List<AnimeCharacter> getAnimeCharacter() {
		return animeCharacter;
	}
	public void setAnimeCharacter(List<AnimeCharacter> animeCharacter) {
		this.animeCharacter = animeCharacter;
	}
	@Override
	public String toString() {
		return "VoiceActor [" + super.toString() + ", animeCharacter=" + animeCharacter + "]";
	}

	
}
