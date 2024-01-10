package com.inodinln.generativeAiTask1.repositories;

import com.inodinln.generativeAiTask1.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
