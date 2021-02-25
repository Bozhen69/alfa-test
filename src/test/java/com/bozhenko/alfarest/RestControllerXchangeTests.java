package com.bozhenko.alfarest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerXchangeTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void getOkAnswer() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/currency-rates/gif?currencyName=EUR");
        mvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    void getBadRequest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/currency-rates/gif?currencyName=DOLARS");
        mvc.perform(requestBuilder).andExpect(status().isBadRequest());
    }

    @Test
    void getErrorRequest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/currency-rates/gif?currencyName=");
        Assertions.assertThrows(Exception.class,()->mvc.perform(requestBuilder).andReturn());
    }

}
