package com.raishin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raishin.entity.DeckEntity;

public interface DeckRepository extends JpaRepository<DeckEntity, Integer> {

}
