package Junit;

import com.mandacarubroker.controller.StockController;
import com.mandacarubroker.domain.stock.RequestStockDto;
import com.mandacarubroker.domain.stock.Stock;
import com.mandacarubroker.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class brokerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("1", "AAPL", "Apple Inc.", 150.0));
        stocks.add(new Stock("2", "GOOGL", "Alphabet Inc.", 2500.0));
        when(stockService.getAllStocks()).thenReturn(stocks);

        List<Stock> result = stockController.getAllStocks();

        assertEquals(stocks.size(), result.size());
        assertEquals(stocks.get(0).getCompanyName(), result.get(0).getCompanyName());
        assertEquals(stocks.get(1).getCompanyName(), result.get(1).getCompanyName());
    }

    @Test
    public void testGetStockById() {
        Stock stock = new Stock("1", "AAPL", "Apple Inc.", 150.0);
        when(stockService.getStockById("1")).thenReturn(Optional.of(stock));

        Stock result = stockController.getStockById("1");

        assertEquals(stock.getCompanyName(), result.getCompanyName());
        assertEquals(stock.getPrice(), result.getPrice());
    }

    @Test
    public void testCreateStock() {
        RequestStockDto requestStockDto = new RequestStockDto("AAPL", "Apple Inc.", 150.0);
        Stock createdStock = new Stock(requestStockDto);
        when(stockService.createStock(any(RequestStockDto.class))).thenReturn(createdStock);

        ResponseEntity<Stock> responseEntity = stockController.createStock(requestStockDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(createdStock.getCompanyName(), responseEntity.getBody().getCompanyName());
    }

    @Test
    public void testUpdateStock() {
        Stock existingStock = new Stock("1", "AAPL", "Apple Inc.", 150.0);
        RequestStockDto updatedStockDto = new RequestStockDto("AAPL", "Apple Inc.", 200.0);
        when(stockService.updateStock("1", new Stock(updatedStockDto))).thenReturn(Optional.of(existingStock));

        Stock updatedStock = stockController.updateStock("1", new Stock(updatedStockDto));

        assertEquals(existingStock.getPrice(), updatedStock.getPrice());
    }

    @Test
    public void testDeleteStock() {
        doNothing().when(stockService).deleteStock("1");

        stockController.deleteStock("1");

        verify(stockService, times(1)).deleteStock("1");
    }
}

