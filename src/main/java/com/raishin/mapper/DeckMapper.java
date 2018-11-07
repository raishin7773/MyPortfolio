package com.raishin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.raishin.entity.DeckEntity;

@Mapper
public interface DeckMapper {
	List<DeckEntity> selectAll();
}
