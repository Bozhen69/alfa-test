package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.controller.external.ExchangerApi;
import com.bozhenko.alfarest.services.ExchangeService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangerApi exchangerAPi;

    @Override
    public JsonNode getAllCurrentRates() {
        return exchangerAPi.getLatestRates();
    }

    @Override
    @Cacheable(value = "yesterdayCurrencyRate", keyGenerator = "dateKeyGenerator")
    public JsonNode getAllYesterdayRates() {
        return exchangerAPi.getYesterdayRates(LocalDate.now().minusDays(1));
    }

}
