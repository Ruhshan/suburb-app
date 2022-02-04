package xyx.ruhshan.suburb.infrastructure.persistance.converter;

import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.infrastructure.persistance.entities.SuburbEntity;
import xyx.ruhshan.suburb.infrastructure.shared.RepositoryConverter;

public class SuburbRepositoryConverter implements RepositoryConverter<SuburbEntity, Suburb> {

    @Override
    public Suburb mapToDomain(SuburbEntity entity) {
        return Suburb.builder()
                .name(entity.getName())
                .postcode(entity.getPostcode())
                .build();
    }

    @Override
    public SuburbEntity mapToTable(Suburb domain) {
        return SuburbEntity.builder()
                .name(domain.getName())
                .postcode(domain.getPostcode())
                .build();
    }
}
