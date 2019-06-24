package com.project.bangumi_community.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.service.AnimeService;

@RestController
public class AnimeController {
	@Autowired
	AnimeService as;
	
	@RequestMapping(value="/getAllAnime", method={RequestMethod.GET,
			RequestMethod.POST}, produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public List<Anime> getAllAnime(){
		List<Anime> li = as.getAllAnime();
        return li;
    }
	
	@RequestMapping(value="/getAnimeByAnimeId/{idAnime}", method={RequestMethod.GET, 
			RequestMethod.POST}, produces= { "text/html;charset=UTF-8" })
	public String getAnimeByAnimeId(Model model, @PathVariable("idAnime") String idAnime) {
		Anime anime = as.getAnimeByAnimeId(idAnime);
		model.addAttribute("anime", anime);
		return "show";
	}
	
	@RequestMapping(value="/getAnimeByName", method={RequestMethod.GET, 
			RequestMethod.POST}, produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<Anime> getAnimeByName(@RequestParam("name")String name) {
		List<Anime> animeList = as.getAnimeByAnimeName(name);
		return animeList;
	}
	
	@RequestMapping(value="/addAnime", method={RequestMethod.GET, 
			RequestMethod.POST}, produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Anime addAnime() {
		Anime anime = new Anime();
		anime.setId("A000005");
		List<AnimeCharacter> acl = new ArrayList<AnimeCharacter>();
		AnimeCharacter ac1 = new AnimeCharacter();
		ac1.setId("AC000005");
		AnimeCharacter ac2 = new AnimeCharacter();
		ac2.setId("AC000006");
		acl.add(ac1);
		acl.add(ac2);
		anime.setAnimeCharacter(acl);
		as.addAnime(anime);
		return anime;
	}

}
