package xyx.ruhshan.suburb.core.location.ports;

import xyx.ruhshan.suburb.core.location.domain.Suburb;

import java.util.List;

public interface SuburbRepositoryService {
    int saveSuburbs(List<Suburb> suburbList);
    List<Suburb> findAllSuburbsByPostcodeRange(Integer startPostcode, Integer endPostcode);
}
