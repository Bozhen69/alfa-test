package com.bozhenko.alfarest.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotBlank;


/**
 * Параметры взаимодействия с сервисом котировок Валют.
 *
 * @author Bozhenko Pavel <bozhenko@reksoft.ru>
 */
@Data
@Component
@ConfigurationProperties(prefix = "services.external.exchange")
@EqualsAndHashCode(callSuper = true)
public class ExchangeServiceProperties extends ExternalServiceProperties {
    @NotBlank
    private String baseCurrencyName;
}
