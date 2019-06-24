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

import com.project.bangumi_community.domain.Anime;

@Mapper
public interface AnimeMapper {
	@Select("SELECT * FROM ANIME")
	@Results({
		@Result(property="id", column="id_anime"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="animeCharacter", column="id_anime",
			many=@Many(select="com.project.bangumi_community.repository.AnimeCharacterMapper.getAnimeCharacterByAnimeId")
		),
		@Result(property="animeTag", column="id_anime",
			many=@Many(select="com.project.bangumi_community.repository.TagMapper.getAnimeTagByAnimeId")
		)
	})
	List<Anime> getAllAnime();
	
	@Select("SELECT * FROM ANIME WHERE id_anime = #{id}")
	@Results({
		@Result(property="id", column="id_anime"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="animeCharacter", column="id_anime",
			many=@Many(select="com.project.bangumi_community.repository.AnimeCharacterMapper.getAnimeCharacterByAnimeId")
		),
		@Result(property="animeTag", column="id_anime",
		many=@Many(select="com.project.bangumi_community.repository.TagMapper.getAnimeTagByAnimeId")
		)
	})
	Anime getAnimeByAnimeId(@Param("id")String id);
	
	@Select("SELECT * FROM ANIME WHERE name_chinese LIKE #{name} OR name_foreign LIKE #{name} "
			+ "OR name_nick LIKE #{name}")
	@Results({
		@Result(property="id", column="id_anime"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="animeCharacter", column="id_anime",
			many=@Many(select="com.project.bangumi_community.repository.AnimeCharacterMapper.getAnimeCharacterByAnimeId")
		),
		@Result(property="animeTag", column="id_anime",
		many=@Many(select="com.project.bangumi_community.repository.TagMapper.getAnimeTagByAnimeId")
		)
	})
	List<Anime> getAnimeByAnimeName(@Param("name")String name);
	
	@Select("SELECT id_anime,name_chinese,name_foreign,name_nick,information FROM ANIME WHERE name_chinese LIKE #{keyword} OR "
			+ "name_nick LIKE #{keyword} OR name_foreign LIKE #{keyword} OR information LIKE #{keyword}")
	@Results({
		@Result(property="id", column="id_anime"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
	})
	List<Anime> getAnimeByKeyword(@Param("keyword")String keyword);
	
	@Insert("INSERT INTO ANIME (id_anime,name_chinese,name_foreign,name_nick,information,cover) VALUES(#{id},#{nameChinese},"
			+ "#{nameForeign},#{nameNick},#{information},#{cover})")
	void addAnime(Anime anime);
	
	@Insert("INSERT INTO ANIME_ANIMECHARACTER (id_anime,id_anime_character) VALUES(#{idAnime},#{idAnimeCharacter})")
	void addAnimeToAnimeCharacter(@Param("idAnime")String idAnime, @Param("idAnimeCharacter")String idAnimeCharacter);

	@Delete("DELETE FROM ANIME_ANIMETAG WHERE id_anime=#{id}")
	void deleteTag(@Param("id")String id);

	@Insert("INSERT INTO ANIME_ANIMETAG (id_anime,id_anime_tag) VALUES(#{idAnime},#{idAnimeTag})")
	void addAnimeTag(@Param("idAnime")String idAnime, @Param("idAnimeTag")String idAnimeTag);

	@Update("UPDATE ANIME SET name_chinese=#{nameChinese},name_foreign=#{nameForeign},name_Nick=#{nameNick},"
			+ "information=#{information},cover=#{cover} "
			+ "WHERE id_anime=#{id}")
	void updateAnime(Anime anime);

	@Delete("DELETE FROM ANIME_ANIMECHARACTER WHERE id_anime=#{id}")
	void deleteAnimeCharacter(@Param("id")String id);

	@Insert("INSERT INTO ANIME_ANIMECHARACTER (id_anime,id_anime_character) VALUES(#{idAnime},#{idAnimeCharacter})")
	void addAnimeCharacter(@Param("idAnime")String idAnime, @Param("idAnimeCharacter")String idAnimeCharacter);
	
	@Select("SELECT * FROM ANIME WHERE id_anime IN (SELECT id_anime FROM anime_animetag WHERE id_anime_tag=#{id})")
	@Results({
		@Result(property="id", column="id_anime"),
		@Result(property="nameChinese", column="name_chinese"),
		@Result(property="nameForeign", column="name_foreign"),
		@Result(property="nameNick", column="name_nick"),
		@Result(property="animeCharacter", column="id_anime",
			many=@Many(select="com.project.bangumi_community.repository.AnimeCharacterMapper.getAnimeCharacterByAnimeId")
		),
	})
	List<Anime> getAnimeByAnimeTagId(@Param("id")String id);
}
