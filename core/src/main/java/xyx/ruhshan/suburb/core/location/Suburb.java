package xyx.ruhshan.suburb.core.location;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import xyx.ruhshan.suburb.core.shared.SelfValidating;

@Data
@AllArgsConstructor
public class Suburb extends SelfValidating<Suburb> {
    @NotEmpty
    private String name;

    @Min(0)
    private Integer postCode;
}
