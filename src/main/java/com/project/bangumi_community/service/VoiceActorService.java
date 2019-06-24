package com.project.bangumi_community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.repository.VoiceActorMapper;

@Component
public class VoiceActorService {
	@Autowired
	VoiceActorMapper vam;
	
	public void addVoiceActor(VoiceActor va) {
		VoiceActor voiceActor = vam.getVoiceActorById(va.getId());
		if(voiceActor == null)
			vam.addVoiceActor(va);
		else
			vam.updateVoiceActor(va);
	}

	public VoiceActor getVoiceActorById(String id) {
		VoiceActor va = vam.getVoiceActorById(id);
		return va;
	}

	public List<VoiceActor> getAllVoiceActor() {
		List<VoiceActor> voiceActorList = vam.getAllVoiceActor();
		return voiceActorList;
	}
}
