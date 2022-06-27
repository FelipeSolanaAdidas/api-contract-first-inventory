package com.adidas.apiteam.core.entities;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;


@Getter
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public class StockItem {

    private UUID id;
    private String name;
    private long availableItems;
    private Date releaseDate;
    private Producer producer;
}
