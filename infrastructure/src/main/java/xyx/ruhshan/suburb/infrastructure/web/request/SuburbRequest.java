package xyx.ruhshan.suburb.infrastructure.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuburbRequest implements Serializable {
    @NotEmpty(message = "Suburb name is required")
    private String name;

    @Min(value = 0, message = "Suburb postCode must be greater than or equal to 0")
    private Integer postcode;
}
