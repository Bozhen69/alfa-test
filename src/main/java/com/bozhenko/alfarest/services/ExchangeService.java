package com.bozhenko.alfarest.services;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
public interface ExchangeService {
    JsonNode getAllCurrentRates();

    JsonNode getAllYesterdayRates();
}
