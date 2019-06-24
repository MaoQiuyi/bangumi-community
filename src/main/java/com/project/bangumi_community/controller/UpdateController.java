package com.project.bangumi_community.controller;


import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bangumi_community.domain.Anime;
import com.project.bangumi_community.domain.AnimeCharacter;
import com.project.bangumi_community.domain.AnimeTag;
import com.project.bangumi_community.domain.VoiceActor;
import com.project.bangumi_community.service.AnimeCharacterService;
import com.project.bangumi_community.service.AnimeService;
import com.project.bangumi_community.service.TagService;
import com.project.bangumi_community.service.VoiceActorService;


public class UpdateController{
	
	
	@Autowired
	AnimeCharacterService acs;
	@Autowired
	AnimeService as;
	@Autowired
	VoiceActorService vas;
	@Autowired
	TagService ts;
	@RequestMapping(path="/update", produces={"text/html;charset=UTF-8"})
	public String update(Model model)  {
		try {
			String animeAddress = "xlsx/anime.xlsx";
			String animeCharacterAddress = "xlsx/animeCharacter.xlsx";
			String voiceActorAddress = "xlsx/voiceActor.xlsx";
			String tagAddress = "xlsx/tag.xlsx";
			
			System.out.println("---------------------voiceactor-----------------------");
			InputStream input = ClassLoader.getSystemResourceAsStream(voiceActorAddress);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell id = row.getCell(0);
				XSSFCell nameChinese = row.getCell(1);
				XSSFCell nameForeign = row.getCell(2);
				XSSFCell nameNick = row.getCell(3);
				XSSFCell gender = row.getCell(4);
				XSSFCell birth = row.getCell(5);
				XSSFCell death = row.getCell(6);
				XSSFCell nationality = row.getCell(7);
				XSSFCell nation = row.getCell(8);
				XSSFCell height = row.getCell(9);
				XSSFCell information = row.getCell(10);
				
				//将表格数据封装到对象中
				VoiceActor va = new VoiceActor();
				if(id != null) va.setId(id.toString());
				if(nameChinese != null) va.setNameChinese(nameChinese.toString());
				if(nameForeign != null) va.setNameForeign(nameForeign.toString());
				if(nameNick != null) va.setNameNick(nameNick.toString());
				if(gender != null) va.setGender(gender.toString());
				if(birth != null) va.setBirth(birth.toString());
				if(death != null) va.setDeath(death.toString()); 
				if(nationality != null) va.setNationality(nationality.toString());
				if(nation != null) va.setNation(nation.toString());
				if(height != null) va.setHeight(height.toString());
				if(information != null) va.setInformation(information.toString());
				
				vas.addVoiceActor(va);
				
				System.out.println(va);
			}
			
			System.out.println("---------------------tag-----------------------");
			
			input = ClassLoader.getSystemResourceAsStream(tagAddress);
			wb = new XSSFWorkbook(input);
			sheet = wb.getSheetAt(0);
			
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell id = row.getCell(0);
				XSSFCell name = row.getCell(1);
				XSSFCell information = row.getCell(2);
				
				//将表格数据封装到对象中
				AnimeTag at = new AnimeTag();
				if(id != null) at.setId(id.toString());
				if(name != null) at.setName(name.toString());
				if(information != null) at.setInformation(information.toString());
				
				ts.addAnimeTag(at);
				
				System.out.println(at);
			}
			
			
			
			System.out.println("---------------------animecharacter-----------------------");
			input = ClassLoader.getSystemResourceAsStream(animeCharacterAddress);
			wb = new XSSFWorkbook(input);
			sheet = wb.getSheetAt(0);
			
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell id = row.getCell(0);
				XSSFCell nameChinese = row.getCell(1);
				XSSFCell nameForeign = row.getCell(2);
				XSSFCell nameNick = row.getCell(3);
				XSSFCell gender = row.getCell(4);
				XSSFCell birth = row.getCell(5);
				XSSFCell death = row.getCell(6);
				XSSFCell nationality = row.getCell(7);
				XSSFCell nation = row.getCell(8);
				XSSFCell height = row.getCell(9);
				XSSFCell information = row.getCell(10);
				XSSFCell voiceActor = row.getCell(11);
				
				//将表格数据封装到对象中
				AnimeCharacter ac = new AnimeCharacter();
				if(id != null) ac.setId(id.toString());
				if(nameChinese != null) ac.setNameChinese(nameChinese.toString());
				if(nameForeign != null) ac.setNameForeign(nameForeign.toString());
				if(nameNick != null) ac.setNameNick(nameNick.toString());
				if(gender != null) ac.setGender(gender.toString());
				if(birth != null) ac.setBirth(birth.toString());
				if(death != null) ac.setDeath(death.toString());
				if(nationality != null) ac.setNationality(nationality.toString());
				if(nation != null) ac.setNation(nation.toString());
				if(height != null) ac.setHeight(height.toString());
				if(information != null) ac.setInformation(information.toString());
				//基本数据存储到数据库
				acs.addAnimeCharacter(ac);
				//处理多对多关系
				String voiceActorStr;
				if(voiceActor == null)
					voiceActorStr = "";
				else
					voiceActorStr = voiceActor.toString();
				acs.updateVoiceActor(ac.getId(), voiceActorStr);
				
				System.out.println(ac);
			}
			
			
			
			System.out.println("---------------------anime-----------------------");
			input = ClassLoader.getSystemResourceAsStream(animeAddress);
			wb = new XSSFWorkbook(input);
			sheet = wb.getSheetAt(0);
			
			for(int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell id = row.getCell(0);
				XSSFCell nameChinese = row.getCell(1);
				XSSFCell nameForeign = row.getCell(2);
				XSSFCell nameNick = row.getCell(3);
				XSSFCell information = row.getCell(4);
				XSSFCell tag = row.getCell(5);
				XSSFCell animeCharacter = row.getCell(6);
				XSSFCell cover = row.getCell(7);
				
				//将表格数据封装到对象中
				Anime a = new Anime();
				if(id != null) a.setId(id.toString());
				if(nameChinese != null) a.setNameChinese(nameChinese.toString());
				if(nameForeign != null) a.setNameForeign(nameForeign.toString());
				if(nameNick != null) a.setNameNick(nameNick.toString());
				if(information != null) a.setInformation(information.toString());
				if(cover != null) a.setCover(cover.toString());
				
				as.addAnime(a);
				
				//更新tag
				String tagStr;
				if(tag == null)
					tagStr = "";
				else
					tagStr = tag.toString();
				as.updateTag(a.getId(), tagStr);
				
				//更新animeCharacter
				String animeCharacterStr;
				if(animeCharacter == null)
					animeCharacterStr = "";
				else
					animeCharacterStr = animeCharacter.toString();
				as.updataAnimeCharacter(a.getId(), animeCharacterStr);
				
				System.out.println(a);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return "index";
	}
}
