package com.bozhenko.alfarest.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@Data
@Component
@ConfigurationProperties(prefix = "services.external.gif")
@EqualsAndHashCode(callSuper = true)
public class GifServiceProperties extends ExternalServiceProperties {

}
