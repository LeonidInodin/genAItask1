package com.inodinln.generativeAiTask1;

import com.inodinln.generativeAiTask1.controllers.MainController;
import com.inodinln.generativeAiTask1.entities.ItemEntity;
import com.inodinln.generativeAiTask1.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class GenerativeAiTask1ApplicationTests {
	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
	private MainController mainController;

	@Test
	public void testGetAllAvailableItems() {
		// Mock data
		ItemEntity item1 = new ItemEntity("Item1", "Description1", BigDecimal.TEN, 5);
		ItemEntity item2 = new ItemEntity("Item2", "Description2", BigDecimal.valueOf(20), 10);
		List<ItemEntity> mockItemList = Arrays.asList(item1, item2);

		// Mock behavior
		when(itemRepository.findAll()).thenReturn(mockItemList);

		// Perform the test
		ResponseEntity<List<ItemEntity>> response = mainController.getAllAvailableItems();

		// Verify the result
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockItemList, response.getBody());
	}

	@Test
	public void testCreateNewItem() {
		// Mock request parameters
		String name = "NewItem";
		String description = "New Description";
		BigDecimal price = BigDecimal.valueOf(15.99);
		Integer quantity = 8;

		// Perform the test
		ResponseEntity<Void> response = mainController.createNewItem(name, description, price, quantity);

		// Verify the result
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		verify(itemRepository, times(1)).save(any(ItemEntity.class));
	}

	@Test
	public void testUpdateItem() {
		// Mock request parameters
		Long id = 1L;
		String newName = "UpdatedItem";
		String newDescription = "Updated Description";
		BigDecimal newPrice = BigDecimal.valueOf(25.99);
		Integer newQuantity = 15;

		// Mock data
		ItemEntity existingItem = new ItemEntity(1L, "OldItem", "Old Description", BigDecimal.TEN, 5);

		// Mock behavior
		when(itemRepository.findById(id)).thenReturn(Optional.of(existingItem));

		// Perform the test
		ResponseEntity<Void> response = mainController.updateItem(id, newName, newDescription, newPrice, newQuantity);

		// Verify the result
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(itemRepository, times(1)).save(existingItem);
		assertEquals(newName, existingItem.getName());
		assertEquals(newDescription, existingItem.getDescription());
		assertEquals(newPrice, existingItem.getPrice());
		assertEquals(newQuantity, existingItem.getQuantity());
	}

	@Test
	public void testUpdateItemNotFound() {
		// Mock request parameters
		Long id = 1L;
		String newName = "UpdatedItem";

		// Mock behavior
		when(itemRepository.findById(id)).thenReturn(Optional.empty());

		// Perform the test
		ResponseEntity<Void> response = mainController.updateItem(id, newName, null, null, null);

		// Verify the result
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		verify(itemRepository, never()).save(any(ItemEntity.class));
	}

}
