package com.project.bangumi_community.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.project.bangumi_community.domain.VoiceActor;

@Mapper
public interface VoiceActorMapper {
	@Select("SELECT * FROM VOICEACTOR WHERE id_voice_actor IN (SELECT id_voice_actor FROM "
			+ "ANIMECHARACTER_VOICEACTOR WHERE id_anime_character = #{idAnimeCharacter})")
	@Results({
		@Result(property="id", column="id_voice_actor"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	List<VoiceActor> getVoiceActorByAnimeCharacterId(@Param("idAnimeCharacter")String idAnimeCharacter);
	
	@Select("SELECT id_voice_actor,name_chinese,name_foreign,name_nick,information FROM VOICEACTOR "
			+ "WHERE name_chinese LIKE #{keyword} OR name_nick LIKE #{keyword} "
			+ "OR name_foreign LIKE #{keyword} OR information LIKE #{keyword}")
	@Results({
		@Result(property="id", column="id_voice_actor"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	List<VoiceActor> getVoiceActorByKeyword(@Param("keyword")String keyword);

	
	@Select("SELECT id_voice_actor FROM VOICEACTOR WHERE name_chinese=#{nameChinese}")
	@Results({
		@Result(property="id", column="id_voice_actor")
	})
	VoiceActor getVoiceActorByNameChinese(@Param("nameChinese")String nameChinese);

	@Insert("INSERT INTO VOICEACTOR (id_voice_actor,name_chinese,name_foreign,name_nick,gender,birth,death,"
			+ "nationality,nation,height,information) "
			+ "VALUES(#{id},#{nameChinese},#{nameForeign},#{nameNick},#{gender},#{birth},"
			+ "#{death},#{nationality},#{nation},#{height},#{information})")
	void addVoiceActor(VoiceActor va);

	@Select("SELECT id_voice_actor,name_chinese,name_foreign,name_nick,gender,birth,death,"
			+ "nationality,nation,height,information FROM VOICEACTOR WHERE id_voice_actor=#{id}")
	@Results({
		@Result(property="id", column="id_voice_actor"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	VoiceActor getVoiceActorById(@Param("id")String id);

	@Update("UPDATE VOICEACTOR SET name_chinese=#{nameChinese},name_foreign=#{nameForeign},name_nick=#{nameNick},"
			+ "gender=#{gender},birth=#{birth},death=#{death},nationality=#{nationality},"
			+ "nation=#{nation},height=#{height},information=#{information} WHERE "
			+ "id_voice_actor=#{id}")
	void updateVoiceActor(VoiceActor va);

	@Select("SELECT * FROM VOICEACTOR")
	@Results({
		@Result(property="id", column="id_voice_actor"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	List<VoiceActor> getAllVoiceActor();
	
	
}
