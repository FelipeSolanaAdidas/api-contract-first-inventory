package usecase;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.exceptions.AddItemException;
import com.adidas.apiteam.core.usecase.AddItemUsesCase;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderStockItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddItemUsesCaseTest {


    @Mock
    private DataProviderStockItem dataProviderStockItem;

    private AddItemUsesCase addItemUsesCase;

    @BeforeEach
    void setUp() {
        addItemUsesCase = new AddItemUsesCase(dataProviderStockItem);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void AddItemSuccessfulTest() throws AddItemException {

        StockItem item = StockItem.builder().build();


        addItemUsesCase.addItem(item);

        verify(dataProviderStockItem).addStockItem(item);
    }

    @Test
    public void AddItemErrorAddingTest() throws AddItemException {

        StockItem item = StockItem.builder().build();

        doThrow(new AddItemException("Error adding item")).when(dataProviderStockItem).addStockItem(item);

        AddItemException thrown = assertThrows(AddItemException.class, () -> {
            addItemUsesCase.addItem(item);
        });

        assertEquals("Error adding item", thrown.getMessage());
    }

}