package com.project.bangumi_community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.AnimeTag;
import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.service.AnimeService;
import com.project.bangumi_community.service.SearchService;
import com.project.bangumi_community.service.TagService;
import com.project.bangumi_community.service.VoiceActorService;
import com.project.bangumi_community.service.AnimeCharacterService;

@Controller
public class SearchController {
	@Autowired
	SearchService ss;
	@Autowired
	AnimeService as;
	@Autowired
	AnimeCharacterService acs;
	@Autowired
	VoiceActorService vas;
	@Autowired
	TagService ts;
	
	@RequestMapping(value="/search", method= {RequestMethod.POST}, 
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String search(Model model, @RequestParam("keyword")String keyword) {
		
		System.out.println(keyword);
		/*
		 * 关键字解析
		 *    符号解析：
		 *    	&(&&)	
		 *    	|(||)	
		 */
		
		/*
		 * 查询得到结果
		 */
		List<Object> result = ss.searchAllByKeyword(keyword);
		model.addAttribute("result", result);
		return "result";
	}
	
	@RequestMapping(value="/anime/{id}", method={RequestMethod.GET}, produces= {"text/html;charset=UTF-8"})
	public String getAnime(Model model, @PathVariable("id")String id) {
		System.out.println(id);
		Anime anime =  as.getAnimeByAnimeId(id);
		model.addAttribute("anime", anime);
		return "anime";
	}
	
	@RequestMapping(value="/anime_character/{id}", method={RequestMethod.GET}, produces= {"text/html;charset=UTF-8"})
	public String getAnimeCharacter(Model model, @PathVariable("id")String id) {
		System.out.println(id);
		AnimeCharacter animeCharacter = acs.getAnimeCharacterById(id);
		model.addAttribute("anime_character", animeCharacter);
		return "anime_character";
	}
	
	@RequestMapping(value="/voice_actor/{id}", method={RequestMethod.GET}, produces= {"text/html;charset=UTF-8"})
	public String getVoiceActor(Model model, @PathVariable("id")String id) {
		System.out.println(id);
		VoiceActor voiceActor = vas.getVoiceActorById(id);
		model.addAttribute("voice_actor", voiceActor);
		return "voice_actor";
	}
	
	@RequestMapping(value="/get/{id}", method={RequestMethod.GET}, produces= {"text/html;charset=UTF-8"})
	public String get(Model model, @PathVariable("id")String id) {
		if(id.startsWith("AC")) {
			AnimeCharacter ac = acs.getAnimeCharacterById(id);
			model.addAttribute("animeCharacter", ac); 
			return "anime_character";
		}
		if(id.startsWith("AT")) {
			AnimeTag animeTag = ts.getAnimeTagById(id);
			model.addAttribute("animeTag", animeTag);
			return "anime_tag";
		}
		if(id.startsWith("VA")) {
			VoiceActor va = vas.getVoiceActorById(id);
			model.addAttribute("voiceActor", va);
			return "voice_actor";
		}
		if(id.startsWith("A")) {
			Anime a = as.getAnimeByAnimeId(id);
			model.addAttribute("anime", a);
			return "anime";
		}
		return "error";
	}
}
