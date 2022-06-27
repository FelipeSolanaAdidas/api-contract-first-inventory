package com.adidas.dataproviders.database;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDataBaseTest {


    private InventoryDataBase inventoryDataBase;

    @BeforeEach
    void setUp() {
        inventoryDataBase = new InventoryDataBase();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStockItemTest() throws AddItemException {
        StockItem item = StockItem.builder().name("ItemOne").build();

        inventoryDataBase.addStockItem(item);

    }

    @Test
    void addStockItemExceptionTest() throws AddItemException {


        AddItemException thrown = assertThrows(AddItemException.class, () -> {
            inventoryDataBase.addStockItem(null);
        });

        assertEquals("empty item not allow", thrown.getMessage());
    }

    @Test
    @DisplayName("FindStock for a item")
    void findStockItemTest() throws AddItemException {

        StockItem item = StockItem.builder().name("ItemOneFindStock").build();
        inventoryDataBase.addStockItem(item);

        List<StockItem> value = inventoryDataBase.findStockItem("FindStock", 0, 1);
        assertNotNull(value);
        assertEquals(1, value.size());
    }

    @Test
    @DisplayName("FindStock for a item ignoring case")
    void findStockItemIgnoreCaseSensitiveTest() throws AddItemException {

        StockItem item = StockItem.builder().name("ItemOneFindStock").build();
        inventoryDataBase.addStockItem(item);

        List<StockItem> value = inventoryDataBase.findStockItem("findstock", 0, 1);
        assertNotNull(value);
        assertEquals(1, value.size());
    }


    @Test
    @DisplayName("FindStock limiting the output")
    void findStockItemLimitTest() throws AddItemException {

        StockItem item = StockItem.builder().name("ItemOneFindStock").build();
        inventoryDataBase.addStockItem(item);

        List<StockItem> value = inventoryDataBase.findStockItem("findstock", 0, 0);
        assertNotNull(value);
        assertEquals(0, value.size());
    }

    @Test
    @DisplayName("FindStock limiting and skiping")
    void findStockItemLimitSkipTest() throws AddItemException {

        inventoryDataBase.addStockItem(StockItem.builder().name("ItemOneFindStock").build());
        inventoryDataBase.addStockItem(StockItem.builder().name("ItemOneFindStock2").build());

        List<StockItem> value = inventoryDataBase.findStockItem("findstock", 1, 1);
        assertNotNull(value);
        assertEquals(1, value.size());
        assertEquals("ItemOneFindStock2", value.get(0).getName());


    }

}