package com.adidas.dataproviders.database;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderStockItem;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InventoryDataBase implements DataProviderStockItem {


    private static final List<StockItem> dbStockItem = Collections.synchronizedList(new LinkedList<>());

    @Override
    public void addStockItem(StockItem item) throws AddItemException {
        if (item == null) {
            throw new AddItemException("empty item not allow");
        }
        dbStockItem.add(item.toBuilder().id(UUID.randomUUID()).build());

    }

    @Override
    public List<StockItem> findStockItem(String searchString, int skip, int limit) {
        return dbStockItem.stream()
                .filter(p -> StringUtils.isEmpty(searchString) || StringUtils.containsIgnoreCase(p.getName(), searchString))
                .skip(skip).limit(limit).collect(Collectors.toList());

    }


}
