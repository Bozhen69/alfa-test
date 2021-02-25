package com.bozhenko.alfarest.services;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
public interface CurrencyRatesService {
    boolean isCurrentRatesMore(String currencyName, JsonNode yesterdayRates, JsonNode currentRates);
}
