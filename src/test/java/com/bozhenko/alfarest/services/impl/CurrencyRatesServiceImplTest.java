package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.mapper.JsonNodeMapper;
import com.bozhenko.alfarest.services.CurrencyRatesService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.when;

/**
 * @author Pavel Bozhenko <bozhenko@reksoft.ru>
 */
@SpringBootTest
class CurrencyRatesServiceImplTest {
    @MockBean
    private JsonNodeMapper jsonNodeMapper;

    @Autowired
    private CurrencyRatesService currencyRatesService;

    private final JsonNode jsonNodeCurrent = Mockito.mock(JsonNode.class);
    private final JsonNode jsonNodeYesterday = Mockito.mock(JsonNode.class);

    @BeforeEach
    public void init(){
        when(jsonNodeMapper.fromToDouble(same(jsonNodeCurrent),eq("RUB"))).thenReturn(5.0);
        when(jsonNodeMapper.fromToDouble(same(jsonNodeCurrent),eq("EUR"))).thenReturn(4.0);
        when(jsonNodeMapper.fromToDouble(same(jsonNodeYesterday),eq("RUB"))).thenReturn(5.0);
        when(jsonNodeMapper.fromToDouble(same(jsonNodeYesterday),eq("EUR"))).thenReturn(2.0);
    }

    @Test
    void isCurrentRatesMore() {
        assertTrue(currencyRatesService.isCurrentRatesMore("EUR", jsonNodeCurrent, jsonNodeYesterday));
        assertFalse(currencyRatesService.isCurrentRatesMore("EUR", jsonNodeYesterday, jsonNodeCurrent));
    }

}