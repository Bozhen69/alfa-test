package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.mapper.JsonNodeMapper;
import com.bozhenko.alfarest.properties.ExchangeServiceProperties;
import com.bozhenko.alfarest.services.CurrencyRatesService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@Service
@RequiredArgsConstructor
public class CurrencyRatesServiceImpl implements CurrencyRatesService {
    private final JsonNodeMapper mapper;
    private  final ExchangeServiceProperties exchangeServiceProperties;

    @Override
    public boolean isCurrentRatesMore(String currencyName, JsonNode yesterdayRates, JsonNode currentRates) {
       return mapper.fromToDouble(currentRates,exchangeServiceProperties.getBaseCurrencyName()) / mapper.fromToDouble(currentRates, currencyName) >=
               mapper.fromToDouble(yesterdayRates,exchangeServiceProperties.getBaseCurrencyName()) / mapper.fromToDouble(yesterdayRates, currencyName);
    }
}
