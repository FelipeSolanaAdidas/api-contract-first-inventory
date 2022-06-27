package com.adidas.apiteam.core.entities;


import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Producer {
    private UUID id;
    private String name;
    private String homePage;
    private String phone;
}
