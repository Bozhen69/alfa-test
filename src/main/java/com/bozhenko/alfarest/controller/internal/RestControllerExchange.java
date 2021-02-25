package com.bozhenko.alfarest.controller.internal;

import com.bozhenko.alfarest.controller.external.CommonApi;
import com.bozhenko.alfarest.controller.external.GifApi;
import com.bozhenko.alfarest.services.CurrencyRatesService;
import com.bozhenko.alfarest.services.ExchangeService;
import com.bozhenko.alfarest.services.GifService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.net.URISyntaxException;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class RestControllerExchange {
    private final CurrencyRatesService currencyRatesService;
    private final ExchangeService exchangeService;
    private final GifService gifService;

    @GetMapping(value = "/currency-rates/gif",produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getCourse(@Valid @NotBlank @RequestParam(value = "currencyName") String currencyName) throws URISyntaxException {
        JsonNode yesterdayRates = exchangeService.getAllYesterdayRates();
        JsonNode currentRates = exchangeService.getAllCurrentRates();
        boolean isMoreThanYesterday = currencyRatesService.isCurrentRatesMore(currencyName,yesterdayRates,currentRates);
        return gifService.getGifByCurrencyRates(isMoreThanYesterday);
    }
}
