package com.adidas.apiteam.core.usecase.boundaries;

import com.adidas.apiteam.core.entities.Producer;
import com.adidas.apiteam.core.exceptions.AddProducerException;

import java.util.UUID;

public interface DataProviderProducer {

    void addProducer(Producer producer) throws AddProducerException;

    Producer getProducer(UUID id);
}
