package com.bozhenko.alfarest.services.impl;

import com.bozhenko.alfarest.controller.external.CommonApi;
import com.bozhenko.alfarest.controller.external.GifApi;
import com.bozhenko.alfarest.mapper.JsonNodeMapper;
import com.bozhenko.alfarest.services.GifService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Pavel Bozhenko <bozhenko@reksoft.ru>
 */
@Service
@RequiredArgsConstructor
public class GifServiceImpl implements GifService {
    private final CommonApi commonApi;
    private final GifApi gifApi;
    private final JsonNodeMapper mapper;

    @Override
    public byte[] getGifByCurrencyRates(boolean isMoreThanYesterday) throws URISyntaxException {
        String searchTag = isMoreThanYesterday ? "rich" : "broke";
        URI gifUri = mapper.fromToUri(gifApi.getRandomGif(searchTag));
        return commonApi.downloadContentByUri(gifUri);
    }
}
