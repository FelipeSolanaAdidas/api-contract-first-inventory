package com.adidas.apiteam.micronaut.service.bean;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchBean {

    private String searchString;
    private int skip;
    private int limit;
}
