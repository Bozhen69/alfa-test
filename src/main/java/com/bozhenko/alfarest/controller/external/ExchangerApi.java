package com.bozhenko.alfarest.controller.external;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDate;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
public interface ExchangerApi {
    @GetMapping(value = "/latest.json")
    JsonNode getLatestRates();

    @GetMapping(value = "/historical/{date}.json")
    JsonNode getYesterdayRates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date);
}
