package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.controller.external.ExchangerApi;
import com.bozhenko.alfarest.services.ExchangeService;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Pavel Bozhenko <bozhenko@reksoft.ru>
 */
@SpringBootTest
class ExchangeServiceTest {

    @Autowired
    private ExchangeService exchangeService;

    @MockBean
    private ExchangerApi exchangerApi;

    @BeforeEach
    public void init(){
        when(exchangerApi.getYesterdayRates(any())).thenAnswer(Answers.RETURNS_MOCKS);
    }

    @Test
    void checkThatCacheWork() {
        JsonNode jsonNode1 = exchangeService.getAllYesterdayRates();
        JsonNode jsonNode2 = exchangeService.getAllYesterdayRates();
        Assertions.assertSame(jsonNode1, jsonNode2);
    }

}