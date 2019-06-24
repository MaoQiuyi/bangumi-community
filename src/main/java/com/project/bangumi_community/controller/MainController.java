package com.project.bangumi_community.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.User;
import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.service.AnimeCharacterService;
import com.project.bangumi_community.service.AnimeService;
import com.project.bangumi_community.service.UserService;
import com.project.bangumi_community.service.VoiceActorService;

@Controller
public class MainController {
	@Autowired
	AnimeService as;
	@Autowired
	AnimeCharacterService acs;
	@Autowired
	VoiceActorService vas;
	@Autowired
	UserService us;
	
	@RequestMapping(path="/", produces={"text/html;charset=UTF-8"})
	public String index(Model model) {
		List<Anime> indexAnime = new ArrayList<Anime>();
		List<Anime> allAnime = as.getAllAnime();
		Random random = new Random(new Date().getTime());
		for(int i = 0; i < 3; i++) {
			indexAnime.add(allAnime.get(random.nextInt(allAnime.size())));
		}
		System.out.println(indexAnime);
		model.addAttribute("indexAnime", indexAnime);
		model.addAttribute("isLogin", false);
		return "index";
	}
	
	@RequestMapping(path="/getAllAnime", produces={"text/html;charset=UTF-8"})
	public String getAllAnime(Model model) {
		List<Anime> animeList = as.getAllAnime();
		model.addAttribute("result", animeList);
		
		return "result";
	}
	
	@RequestMapping(path="/getAllAnimeCharacter", produces={"text/html;charset=UTF-8"})
	public String getAllAnimeCharacter(Model model) {
		List<AnimeCharacter> animeCharacterList = acs.getAllAnimeCharacter();
		model.addAttribute("result", animeCharacterList);
		
		return "result";
	}
	
	@RequestMapping(path="/getAllVoiceActor", produces={"text/html;charset=UTF-8"})
	public String getAllVoiceActor(Model model) {
		List<VoiceActor> voiceActorList = vas.getAllVoiceActor();
		model.addAttribute("result", voiceActorList);
		return "result";
	}
	
	@RequestMapping(path="/login", produces={"text/html;charset=UTF-8"})
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(path="/loginCheck", produces={"text/html;charset=UTF-8"})
	public String loginCheck(Model model, @RequestParam("username") String name, @RequestParam("password") String password ) {
		User user = us.loginCheck(name, password);
		if(user == null) 
			return "error";
		index(model);
		model.addAttribute("isLogin", true);
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(path="/logout", produces={"text/html;charset=UTF-8"})
	public String logout(Model model) {
		return "index";
	}
}
