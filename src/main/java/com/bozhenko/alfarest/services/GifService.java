package com.bozhenko.alfarest.services;

import java.net.URISyntaxException;

/**
 * @author Pavel Bozhenko <bozhenko@reksoft.ru>
 */
public interface GifService {
    byte[] getGifByCurrencyRates(boolean isMoreThanYesterday) throws URISyntaxException;
}
