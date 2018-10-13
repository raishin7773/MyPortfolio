package com.raishin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.raishin.domain.Fruit;

@Mapper
public interface FruitMapper {
	List<Fruit> selectAll();
}
