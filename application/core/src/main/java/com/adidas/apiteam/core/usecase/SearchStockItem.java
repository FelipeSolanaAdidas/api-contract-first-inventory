package com.adidas.apiteam.core.usecase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchStockItem {

    private String searchString;
    private int skip;
    private int limit;
}
