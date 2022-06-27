package usecase;

import com.adidas.apiteam.core.entities.StockItem;
import com.adidas.apiteam.core.usecase.SearchItemUseCase;
import com.adidas.apiteam.core.usecase.SearchStockItem;
import com.adidas.apiteam.core.usecase.boundaries.DataProviderStockItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class SearchItemUseCaseTest {

    @InjectMocks
    private SearchItemUseCase searchItemUseCase;

    @Mock
    private DataProviderStockItem dataProviderStockItem;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchStockItemsTest() {

        String nameItem = "myItem";

        SearchStockItem search = SearchStockItem.builder()
                .searchString(nameItem).skip(0).limit(100)
                .build();

        when(dataProviderStockItem
                .findStockItem(anyString(), anyInt(), anyInt()))
                .thenReturn(Arrays.asList(StockItem.builder().name(nameItem)
                        .build()));

        List<StockItem> stockItems = searchItemUseCase.searchStockItem(search);

        assertNotNull(stockItems);
        assertEquals(1, stockItems.size());


        verify(dataProviderStockItem).findStockItem(search.getSearchString(), search.getSkip(), search.getLimit());


    }
}