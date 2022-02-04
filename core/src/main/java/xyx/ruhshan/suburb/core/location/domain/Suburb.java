package xyx.ruhshan.suburb.core.location.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import xyx.ruhshan.suburb.core.location.shared.SelfValidating;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class Suburb extends SelfValidating<Suburb> implements Serializable {

    @NotEmpty(message = "Suburb name is required")
    private String name;

    @Min(value = 0, message = "Suburb postCode must be greater than or equal to 0")
    private Integer postcode;

}
