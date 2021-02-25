package com.bozhenko.alfarest.controller.external;

import feign.RequestLine;
import java.net.URI;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */

public interface CommonApi {
    @RequestLine("GET")
    byte[] downloadContentByUri(URI baseUri);
}
