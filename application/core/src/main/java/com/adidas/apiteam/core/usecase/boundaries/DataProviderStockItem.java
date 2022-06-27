package com.adidas.apiteam.core.usecase.boundaries;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;

import java.util.List;

public interface DataProviderStockItem {
    void addStockItem(StockItem item) throws AddItemException;
    
    List<StockItem> findStockItem(String searchString, int skip, int limit);
}
