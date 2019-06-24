package com.project.bangumi_community.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.project.bangumi_community.domain.AnimeCharacter;

@Mapper
public interface AnimeCharacterMapper {
	@Select("SELECT * FROM ANIMECHARACTER WHERE id_anime_character IN "
			+ "(SELECT id_anime_character FROM ANIME_ANIMECHARACTER WHERE id_anime = #{id})")
	@Results({
		@Result(property="id", column="id_anime_character"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="voiceActor", column="id_anime_character",
				many=@Many(select="com.project.bangumi_community.repository."
						+ "VoiceActorMapper.getVoiceActorByAnimeCharacterId"))
	})
	List<AnimeCharacter> getAnimeCharacterByAnimeId(@Param("id")String id);
	
	@Select("SELECT id_anime_character FROM ANIMECHARACTER")
	@Results({
		@Result(property="id", column="id_anime_character")
	})
	List<AnimeCharacter> getAllAnimeCharacterId();
	
	@Select("SELECT id_anime_character,name_chinese,name_foreign,name_nick,information FROM ANIMECHARACTER "
			+ "WHERE name_chinese LIKE #{keyword} OR name_nick LIKE #{keyword} OR name_foreign LIKE #{keyword} "
			+ "OR information LIKE #{keyword}")
	@Results({
		@Result(property="id", column="id_anime_character"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	List<AnimeCharacter> getAnimeCharacterByKeyword(@Param("keyword")String keyword);
	
	@Select("SELECT * FROM ANIMECHARACTER WHERE id_anime_character = #{id}")
	@Results({
		@Result(property="id", column="id_anime_character"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	AnimeCharacter getAnimeCharacterById(@Param("id")String id);
	
	@Select("SELECT * FROM ANIMECHARACTER WHERE id_anime_character = #{id}")
	@Results({
		@Result(property="id", column="id_anime_character"),
		@Result(property="voiceActor", column="id_anime_character",
		many=@Many(select="com.project.bangumi_community.repository." + 
				"VoiceActorMapper.getVoiceActorByAnimeCharacterId")
		)
	})
	AnimeCharacter getVoiceActorListById(@Param("id")String id);
	
	@Insert("INSERT INTO ANIMECHARACTER (id_anime_character,name_chinese,name_foreign,name_nick,"
			+ "gender,birth,death,nationality,nation,height,information) VALUES(#{id},"
			+ "#{nameChinese},#{nameForeign},#{nameNick},#{gender},#{birth},#{death},#{nationality},"
			+ "#{nation},#{height},#{information})")
	void addAnimeCharacter(AnimeCharacter animeCharacter);

	@Update("UPDATE ANIMECHARACTER SET name_chinese=#{nameChinese},name_foreign=#{nameForeign},name_nick=#{nameNick},"
			+ "gender=#{gender},birth=#{birth},death=#{death},nationality=#{nationality},"
			+ "nation=#{nation},height=#{height},information=#{information} WHERE "
			+ "id_anime_character=#{id}")
	void updateAnimeCharacter(AnimeCharacter ac);

	@Delete("DELETE FROM ANIMECHARACTER_VOICEACTOR WHERE id_anime_character=#{id}")
	void deleteVoiceActor(@Param("id")String id);

	@Insert("INSERT INTO ANIMECHARACTER_VOICEACTOR (id_anime_character,id_voice_actor) VALUES(#{idAnimeCharacter},#{idVoiceActor})")
	void addVoiceActor(@Param("idAnimeCharacter")String idAnimeCharacter, @Param("idVoiceActor")String idVoiceActor);

	@Select("SELECT id_anime_character FROM ANIMECHARACTER WHERE name_chinese=#{nameChinese}")
	@Results({
		@Result(property="id", column="id_anime_character")
	})
	AnimeCharacter getAnimeCharacterByNameChinese(@Param("nameChinese")String nameChinese);

	@Select("SELECT * FROM ANIMECHARACTER")
	@Results({
		@Result(property="id", column="id_anime_character"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="voiceActor", column="id_anime_character",
		many=@Many(select="com.project.bangumi_community.repository." + 
				"VoiceActorMapper.getVoiceActorByAnimeCharacterId")
		)
	})
	List<AnimeCharacter> getAllAnimeCharacter();
}
