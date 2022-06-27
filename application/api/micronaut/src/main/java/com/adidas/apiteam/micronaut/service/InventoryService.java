package com.adidas.apiteam.micronaut.service;

import com.adidas.apiteam.core.entities.Producer;
import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import com.adidas.apiteam.core.usecase.AddItemUsesCase;
import com.adidas.apiteam.core.usecase.SearchItemUseCase;
import com.adidas.apiteam.core.usecase.SearchStockItem;
import com.adidas.apiteam.micronaut.api.ApiException;
import com.adidas.apiteam.micronaut.model.InventoryItem;
import com.adidas.apiteam.micronaut.model.Manufacturer;
import com.adidas.apiteam.micronaut.service.bean.SearchBean;
import io.micronaut.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Singleton
public class InventoryService {

    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @Inject
    private SearchItemUseCase searchItemUseCase;
    @Inject
    private AddItemUsesCase addItemUsesCase;


    public void addInventory(InventoryItem item) throws ApiException {

        try {
            addItemUsesCase.addItem(transformToStockItem(item));
        } catch (AddItemException e) {
            log.error("Error adding item {}", e.getMessage());
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    private StockItem transformToStockItem(InventoryItem item) {

        long numAvailable = item.getAvailableItems() == null ? 0 : item.getAvailableItems().longValue();

        return StockItem.builder()
                .name(item.getName())
                .releaseDate(item.getReleaseDate())
                .producer(transformToProducer(item.getManufacturer()))
                .availableItems(numAvailable)
                .build();

    }

    private Producer transformToProducer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            return null;
        }
        return Producer.builder()
                .homePage(manufacturer.getHomePage())
                .name(manufacturer.getName())
                .phone(manufacturer.getPhone())
                .build();

    }

    public List<InventoryItem> searchInventory(SearchBean searchBean) {

        List<StockItem> stockItems = searchItemUseCase.searchStockItem(transform(searchBean));

        return transformFromDTO(stockItems);
    }

    private List<InventoryItem> transformFromDTO(List<StockItem> stockItems) {

        return stockItems.stream().map(s -> transformFromDTO(s)).collect(Collectors.toList());
    }

    private InventoryItem transformFromDTO(StockItem s) {
        InventoryItem item = new InventoryItem();

        item.setId(s.getId());
        item.setAvailableItems(BigDecimal.valueOf(s.getAvailableItems()));
        item.setName(s.getName());
        item.setReleaseDate(s.getReleaseDate());
        item.setManufacturer(transformDTO(s.getProducer()));

        return item;
    }

    private Manufacturer transformDTO(Producer producer) {
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName(producer.getName());
        manufacturer.setPhone(producer.getPhone());
        manufacturer.setHomePage(producer.getHomePage());

        return manufacturer;
    }


    private SearchStockItem transform(SearchBean searchBean) {
        return SearchStockItem.builder()
                .searchString(searchBean.getSearchString())
                .limit(searchBean.getLimit())
                .skip(searchBean.getSkip())
                .build();

    }

}
