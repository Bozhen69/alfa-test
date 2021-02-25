package com.bozhenko.alfarest.properties;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;

/**
 * @author Pavel Bozhenko <bozhenko@rekfost.ru>
 */
@Data
@Validated
public abstract class ExternalServiceProperties {
    /** Адрес сервиса. */
    @NotBlank
    private String url;
    /** Ключ для доступа к сервису */
    @NotBlank
    private String apiKey;
}
