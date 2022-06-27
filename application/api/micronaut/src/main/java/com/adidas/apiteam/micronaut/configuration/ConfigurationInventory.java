package com.adidas.apiteam.micronaut.configuration;

import com.adidas.apiteam.core.usecase.AddItemUsesCase;
import com.adidas.apiteam.core.usecase.SearchItemUseCase;
import com.adidas.dataproviders.database.InventoryDataBase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public class ConfigurationInventory {

    @Bean
    public AddItemUsesCase addItemUsesCase() {
        InventoryDataBase inventoryDB = new InventoryDataBase();

        return new AddItemUsesCase(inventoryDB);
    }

    @Bean
    public SearchItemUseCase searchItemUseCase() {
        InventoryDataBase inventoryDB = new InventoryDataBase();

        return new SearchItemUseCase(inventoryDB);
    }
}
