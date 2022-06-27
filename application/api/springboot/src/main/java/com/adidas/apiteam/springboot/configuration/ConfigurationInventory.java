package com.adidas.apiteam.springboot.configuration;

import com.adidas.apiteam.core.usecase.AddItemUsesCase;
import com.adidas.apiteam.core.usecase.SearchItemUseCase;
import com.adidas.dataproviders.database.InventoryDataBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
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
