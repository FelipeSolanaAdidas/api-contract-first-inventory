package com.adidas.apiteam.core.usecase;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderStockItem;

import java.util.List;

public class SearchItemUseCase {

    private final DataProviderStockItem dataProviderStockItem;

    public SearchItemUseCase(DataProviderStockItem dataProviderStockItem) {
        this.dataProviderStockItem = dataProviderStockItem;
    }

    public List<StockItem> searchStockItem(SearchStockItem search) {

        //Expected some business logic here
        List<StockItem> items = dataProviderStockItem.findStockItem(search.getSearchString(), search.getSkip(), search.getLimit());
        return items;
    }
}