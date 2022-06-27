package com.adidas.apiteam.micronaut.api;

import com.adidas.apiteam.micronaut.model.InventoryItem;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@MicronautTest
class InventoryApiControllerTest {

    @Inject
    private InventoryAPIController api;

    @Test
    void addInventoryTest() {
        InventoryItem body = new InventoryItem();
        try {
            api.addInventory(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void searchInventoryTest() {
        String searchString = "searchString_example";
        Integer skip = 56;
        Integer limit = 56;
        try {
            api.searchInventory(searchString, skip, limit).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

}
