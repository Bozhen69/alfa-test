package com.bozhenko.alfarest.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@Component
public class JsonNodeMapper {
    public Double fromToDouble(JsonNode jsonNode, String currencyName){
        Optional<JsonNode> currency = Optional.ofNullable(jsonNode.get("rates").get(currencyName));
        if(currency.isPresent()){
            return currency.get().asDouble();
        }
        throw new HttpMessageNotReadableException("Currency with name " + currencyName + "not allowed");
    }

    public URI fromToUri(JsonNode jsonNode) throws URISyntaxException {
        return new URI(jsonNode.get("data").get("image_url").asText());
    }
}
