package ro.msg.learning.controller;

/**
 * Created by vancer at 2/18/2019
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.service.StockService;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(produces = "text/csv", value = "/csv/{locationId}")
    public @ResponseBody
    List<Stock> exportStock(@PathVariable("locationId") Long locationId) {

        return stockService.exportStock(locationId);
    }
}
