package xyx.ruhshan.suburb.infrastructure.persistance.impl;

import org.springframework.stereotype.Service;
import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.ports.SuburbRepositoryService;
import xyx.ruhshan.suburb.infrastructure.persistance.converter.SuburbRepositoryConverter;
import xyx.ruhshan.suburb.infrastructure.persistance.entities.SuburbEntity;
import xyx.ruhshan.suburb.infrastructure.persistance.repositories.SuburbRepository;

import java.util.List;

@Service
public class SuburbRepositoryServiceImpl implements SuburbRepositoryService {
    private final SuburbRepository suburbRepository;
    private final SuburbRepositoryConverter suburbRepositoryConverter;

    public SuburbRepositoryServiceImpl(SuburbRepository suburbRepository, SuburbRepositoryConverter suburbRepositoryConverter) {
        this.suburbRepository = suburbRepository;
        this.suburbRepositoryConverter = suburbRepositoryConverter;
    }

    @Override
    public int saveSuburbs(List<Suburb> suburbList) {
       List<SuburbEntity> suburbEntities = suburbList.stream().map(suburbRepositoryConverter::mapToTable)
               .collect(java.util.stream.Collectors.toList());
       var result = suburbRepository.saveAll(suburbEntities);suburbEntities.stream().map(suburbRepository::save);
       return result.size();
    }

    @Override
    public List<Suburb> findAllSuburbsByPostcodeRange(Integer startPostcode, Integer endPostcode) {
        var result =  suburbRepository.findByPostcodeBetween(startPostcode, endPostcode);
        return result.stream().map(suburbRepositoryConverter::mapToDomain).collect(java.util.stream.Collectors.toList());

    }
}
