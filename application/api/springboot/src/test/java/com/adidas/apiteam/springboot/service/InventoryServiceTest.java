package com.adidas.apiteam.springboot.service;

import com.adidas.apiteam.core.entities.Producer;
import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import com.adidas.apiteam.core.usecase.AddItemUsesCase;
import com.adidas.apiteam.core.usecase.SearchItemUseCase;
import com.adidas.apiteam.core.usecase.SearchStockItem;
import com.adidas.apiteam.springboot.api.ApiException;
import com.adidas.apiteam.springboot.model.InventoryItem;
import com.adidas.apiteam.springboot.service.bean.SearchBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private SearchItemUseCase searchItemUseCase;
    @Mock
    private AddItemUsesCase addItemUsesCase;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void searchInventoryTest() {

        //given
        SearchBean search = SearchBean.builder().searchString("MyItem").limit(100).skip(0).build();

        StockItem myStockOne = StockItem.builder()
                .id(UUID.randomUUID()).availableItems(1).name("MyItem").releaseDate(new Date())
                .producer(Producer.builder().id(UUID.randomUUID()).build())
                .build();
        StockItem myStockTwo = StockItem.builder()
                .id(UUID.randomUUID()).availableItems(1).name("MyItem").releaseDate(new Date())
                .producer(Producer.builder().id(UUID.randomUUID()).build())
                .build();

        List<StockItem> stockItems = Arrays.asList(myStockOne, myStockTwo);

        when(searchItemUseCase.searchStockItem(any(SearchStockItem.class))).thenReturn(stockItems);

        //When
        List<InventoryItem> values = inventoryService.searchInventory(search);

        //Then
        ArgumentCaptor<SearchStockItem> inputCaptor = ArgumentCaptor.forClass(SearchStockItem.class);
        verify(searchItemUseCase).searchStockItem(inputCaptor.capture());

        SearchStockItem captureSearch = inputCaptor.getValue();
        assertAll(
                () -> assertEquals(search.getLimit(), captureSearch.getLimit()),
                () -> assertEquals(search.getSkip(), captureSearch.getSkip()),
                () -> assertEquals(search.getSearchString(), captureSearch.getSearchString())
        );

        assertEquals(2, values.size());
        //Check all properties
        assertEquals(myStockOne.getName(), values.get(0).getName());
        assertEquals(myStockTwo.getName(), values.get(1).getName());

    }

    @Test
    public void addItemTest() throws ApiException, AddItemException {

        InventoryItem item = new InventoryItem();
        item.setName("NameItem");
        item.setAvailableItems(BigDecimal.ONE);


        inventoryService.addInventory(item);

        verifyInputCallAddItem(item);
    }

    @Test
    public void addItemExceptionTest() throws ApiException, AddItemException {

        InventoryItem item = new InventoryItem();
        item.setName("NameItem");
        item.setAvailableItems(BigDecimal.ONE);

        doThrow(new AddItemException("error adding item")).when(addItemUsesCase).addItem(any(StockItem.class));

        ApiException thrown = assertThrows(ApiException.class, () -> {
            inventoryService.addInventory(item);
        });

        assertEquals("error adding item", thrown.getMessage());


        verifyInputCallAddItem(item);
    }

    private void verifyInputCallAddItem(InventoryItem item) throws AddItemException {
        ArgumentCaptor<StockItem> captor = ArgumentCaptor.forClass(StockItem.class);

        verify(addItemUsesCase).addItem(captor.capture());

        StockItem captureStockItem = captor.getValue();
        assertAll(
                () -> assertEquals(item.getName(), captureStockItem.getName()),
                () -> assertEquals(item.getAvailableItems().longValue(), captureStockItem.getAvailableItems())
        );
    }
}