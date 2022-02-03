package xyx.ruhshan.suburb.core.location.usecase;

import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.ports.SuburbRepositoryService;

import java.util.List;

public class FetchSuburbsByPostCodeRangeUseCaseImpl implements FetchSuburbsByPostCodeRangeUseCase {
    private final SuburbRepositoryService suburbRepositoryService;

    public FetchSuburbsByPostCodeRangeUseCaseImpl(SuburbRepositoryService suburbRepositoryService) {
        this.suburbRepositoryService = suburbRepositoryService;
    }

    public List<String> execute(Integer postCodeFrom, Integer postCodeTo) {
        var suburbList =  suburbRepositoryService.findAllSuburbsByPostcodeRange(postCodeFrom,postCodeTo);
        return suburbList.stream().map(Suburb::getName)
                .sorted().collect(java.util.stream.Collectors.toList());

    }
}
