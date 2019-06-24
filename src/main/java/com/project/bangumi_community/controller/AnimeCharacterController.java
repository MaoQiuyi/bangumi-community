package com.project.bangumi_community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.service.AnimeCharacterService;

@RestController
public class AnimeCharacterController {
	@Autowired
	AnimeCharacterService acs;
	
	@RequestMapping(value="/addAnimeCharacter", method={RequestMethod.GET, 
			RequestMethod.POST}, produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public AnimeCharacter addAnimeCharacter() {
		AnimeCharacter ac = new AnimeCharacter();
		ac.setId("AC000005");
		ac.setBirth("1991-04-05");
		acs.addAnimeCharacter(ac);
		return ac;
	}
	
}
