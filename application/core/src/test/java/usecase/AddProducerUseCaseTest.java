package usecase;

import com.adidas.apiteam.core.entities.Producer;
import com.adidas.apiteam.core.exceptions.AddProducerException;
import com.adidas.apiteam.core.usecase.AddProducerUseCase;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderProducer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AddProducerUseCaseTest {

    private AddProducerUseCase addProducerUseCase;

    @Mock
    private DataProviderProducer dataProviderProducer;

    @BeforeEach
    void setUp() {
        addProducerUseCase = new AddProducerUseCase(dataProviderProducer);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void addProducerTest() throws AddProducerException {
        Producer producer = Producer.builder().build();

        addProducerUseCase.addProducer(producer);

        verify(dataProviderProducer).addProducer(producer);
    }


    @Test
    void setAddProducerExceptionTest() throws AddProducerException {
        Producer producer = Producer.builder().build();

        doThrow(new AddProducerException("producer exception")).when(dataProviderProducer).addProducer(producer);

        AddProducerException thrown = assertThrows(AddProducerException.class, () -> {
            addProducerUseCase.addProducer(producer);
        });

        assertEquals("producer exception", thrown.getMessage());
    }
}