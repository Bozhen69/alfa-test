package com.bozhenko.alfarest.controller.external;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Param;
import feign.RequestLine;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
public interface GifApi {
    @RequestLine("GET /v1/gifs/random?tag={tag}")
    JsonNode getRandomGif(@Param("tag") String tag);
}
