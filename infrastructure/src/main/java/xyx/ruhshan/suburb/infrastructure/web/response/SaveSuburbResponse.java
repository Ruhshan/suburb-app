package xyx.ruhshan.suburb.infrastructure.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveSuburbResponse implements Serializable {
    private Integer createdSuburbCount;
}
