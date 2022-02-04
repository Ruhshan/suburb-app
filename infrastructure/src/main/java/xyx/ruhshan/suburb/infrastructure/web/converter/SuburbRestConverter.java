package xyx.ruhshan.suburb.infrastructure.web.converter;

import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.infrastructure.shared.RestConverter;
import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;

public class SuburbRestConverter implements RestConverter<SuburbRequest, Suburb> {
    @Override
    public Suburb mapToDomain(SuburbRequest request) {
        return Suburb.builder()
                .name(request.getName())
                .postcode(request.getPostcode())
                .build();
    }
}
