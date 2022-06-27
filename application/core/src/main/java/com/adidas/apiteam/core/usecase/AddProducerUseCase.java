package com.adidas.apiteam.core.usecase;

import com.adidas.apiteam.core.entities.Producer;
import com.adidas.apiteam.core.exceptions.AddProducerException;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderProducer;

public class AddProducerUseCase {

    private final DataProviderProducer dataProviderProducer;

    public AddProducerUseCase(DataProviderProducer dataProviderProducer) {
        this.dataProviderProducer = dataProviderProducer;
    }

    public void addProducer(Producer producer) throws AddProducerException {
        //We expect some Business Logic here
        dataProviderProducer.addProducer(producer);
    }
}
