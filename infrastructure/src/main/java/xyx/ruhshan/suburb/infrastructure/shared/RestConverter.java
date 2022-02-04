package xyx.ruhshan.suburb.infrastructure.shared;

import java.io.Serializable;

public interface RestConverter<R extends Serializable, E extends Serializable> {

    default E mapToDomain(final R rest) {
        throw new UnsupportedOperationException();
    }
}
