package com.raishin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.raishin.entity.IndexEntity;
import com.raishin.form.IndexForm;

@Mapper
public interface IndexMapper {
	IndexEntity selectLogin(IndexForm form);
}
