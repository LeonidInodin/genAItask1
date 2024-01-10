package com.inodinln.generativeAiTask1.controllers;

import com.inodinln.generativeAiTask1.entities.ItemEntity;
import com.inodinln.generativeAiTask1.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/items/")
@Transactional(readOnly = true)
public class MainController {

    private final ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<ItemEntity>> getAllAvailableItems() {
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> createNewItem(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") BigDecimal price,
            @RequestParam(name = "quantity") Integer quantity) {
        itemRepository.save(new ItemEntity(name, description, price, quantity));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Void> updateItem(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "newName", required = false) String newName,
            @RequestParam(name = "newDescription", required = false) String newDescription,
            @RequestParam(name = "price", required = false) BigDecimal newPrice,
            @RequestParam(name = "quantity", required = false) Integer newQuantity) {
        Optional<ItemEntity> result = itemRepository.findById(id);
        if (result.isEmpty()) return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        ItemEntity entityToBeUpdated = result.get();
        Optional.ofNullable(newName).ifPresent(entityToBeUpdated::setName);
        Optional.ofNullable(newDescription).ifPresent(entityToBeUpdated::setDescription);
        Optional.ofNullable(newPrice).ifPresent(entityToBeUpdated::setPrice);
        Optional.ofNullable(newQuantity).ifPresent(entityToBeUpdated::setQuantity);
        itemRepository.save(entityToBeUpdated);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
