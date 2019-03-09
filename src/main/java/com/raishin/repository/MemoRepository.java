package com.raishin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.raishin.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Integer> {

  @Query("select me from MemoEntity me where me.id = :id ")
  public MemoEntity findById(@Param("id") int id);
}
