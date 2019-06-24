package com.project.bangumi_community.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.project.bangumi_community.domain.AnimeTag;

@Mapper
public interface TagMapper {
	@Insert("INSERT INTO ANIMETAG (id_anime_tag,name,information) VALUES(#{id},#{name},#{information})")
	public void addAnimeTag(AnimeTag animeTag);
	
	@Select("SELECT * FROM ANIMETAG WHERE name=#{name}")
	@Results({
		@Result(property="id", column="id_anime_tag")
	})
	public AnimeTag getAnimeTagByName(@Param("name")String name);

	@Update("UPDATE ANIMETAG SET name=#{name},information=#{information} WHERE id_anime_tag=#{id}")
	public void updateAnimeTag(AnimeTag animeTag);
	
	@Select("SELECT * FROM ANIMETAG WHERE id_anime_tag=#{id}")
	@Results({
		@Result(property="id",column="id_anime_tag"),
		@Result(property="anime",column="id_anime_tag",
		many=@Many(select="com.project.bangumi_community.repository.AnimeMapper.getAnimeByAnimeTagId"))
	})
	public AnimeTag getAnimeTagById(@Param("id")String id);
	
	@Select("SELECT * FROM ANIMETAG WHERE id_anime_tag IN (SELECT id_anime_tag FROM anime_animetag WHERE "
			+ "id_anime=#{id})")
	@Results({
		@Result(property="id", column="id_anime_tag")
	})
	public List<AnimeTag> getAnimeTagByAnimeId(@Param("id")String id);
}
