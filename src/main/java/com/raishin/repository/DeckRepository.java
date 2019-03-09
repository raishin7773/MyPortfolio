package com.raishin.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.raishin.entity.DeckEntity;

public interface DeckRepository extends JpaRepository<DeckEntity, Integer> {

  @Query("select md from DeckEntity md order by (md.win + md.lose + md.draw) desc")
  public List<DeckEntity> findAllSort();

}
