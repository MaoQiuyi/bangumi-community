package com.project.bangumi_community.domain;

import java.util.List;

import com.project.bangumi_community.domain.base.Character;

public class AnimeCharacter extends Character {
	private List<Anime> anime;
	private List<VoiceActor> voiceActor;

	public List<Anime> getAnime() {
		return anime;
	}

	public void setAnime(List<Anime> anime) {
		this.anime = anime;
	}

	public List<VoiceActor> getVoiveActor() {
		return voiceActor;
	}

	public void setVoiveActor(List<VoiceActor> voiveActor) {
		this.voiceActor = voiveActor;
	}

	@Override
	public String toString() {
		return "AnimeCharacter [" + super.toString() + ", anime=" + anime + ", voiceActor=" + voiceActor
				+ "]";
	}
	
	
	
}
