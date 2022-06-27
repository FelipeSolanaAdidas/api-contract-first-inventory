package com.adidas.apiteam.core.usecase;


import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderStockItem;

public class AddItemUsesCase {

    private final DataProviderStockItem dataProviderStockItem;

    public AddItemUsesCase(DataProviderStockItem dataProviderStockItem) {
        this.dataProviderStockItem = dataProviderStockItem;
    }

    public void addItem(StockItem item) throws AddItemException {
        //We expect Business Logic Here
        dataProviderStockItem.addStockItem(item);
    }
}
