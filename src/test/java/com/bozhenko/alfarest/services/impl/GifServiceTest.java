package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.controller.external.CommonApi;
import com.bozhenko.alfarest.controller.external.GifApi;
import com.bozhenko.alfarest.mapper.JsonNodeMapper;
import com.bozhenko.alfarest.services.GifService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author Pavel Bozhenko <bozhenko@reksoft.ru>
 */
@SpringBootTest
class GifServiceTest {

    @MockBean
    private  CommonApi commonApi;

    @MockBean
    private  GifApi gifApi;

    @MockBean
    private  JsonNodeMapper mapper;

    @Autowired
    private GifService gifService;

    @BeforeEach
    public void init() throws URISyntaxException {
        when(commonApi.downloadContentByUri(any())).thenReturn(new byte[]{});
        when(mapper.fromToUri(any())).thenReturn(new URI("https://www.somewebsite.org"));
        when(gifApi.getRandomGif(ArgumentMatchers.eq("broke"))).thenThrow(RuntimeException.class);
        when(gifApi.getRandomGif(eq("rich"))).then(Answers.RETURNS_MOCKS);
    }

    @Test
    void shouldCallRich() throws URISyntaxException {
        Assertions.assertNotNull(gifService.getGifByCurrencyRates(true));
    }
}