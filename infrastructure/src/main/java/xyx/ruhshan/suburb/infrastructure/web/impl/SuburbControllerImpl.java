package xyx.ruhshan.suburb.infrastructure.web.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;
import xyx.ruhshan.suburb.core.location.usecase.FetchSuburbsByPostCodeRangeUseCase;
import xyx.ruhshan.suburb.core.location.usecase.SaveSuburbsUseCase;
import xyx.ruhshan.suburb.infrastructure.web.SuburbController;
import xyx.ruhshan.suburb.infrastructure.web.converter.SuburbRestConverter;
import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;
import xyx.ruhshan.suburb.infrastructure.web.response.SaveSuburbResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SuburbControllerImpl extends AbstractController implements SuburbController  {
    private final SaveSuburbsUseCase saveSuburbsUseCase;
    private final SuburbRestConverter suburbRestConverter;
    private final FetchSuburbsByPostCodeRangeUseCase fetchSuburbsByPostCodeRangeUseCase;

    public SuburbControllerImpl(SaveSuburbsUseCase saveSuburbsUseCase, SuburbRestConverter suburbRestConverter, FetchSuburbsByPostCodeRangeUseCase fetchSuburbsByPostCodeRangeUseCase) {
        this.saveSuburbsUseCase = saveSuburbsUseCase;
        this.suburbRestConverter = suburbRestConverter;
        this.fetchSuburbsByPostCodeRangeUseCase = fetchSuburbsByPostCodeRangeUseCase;
    }

    @Override
    @PostMapping("/suburbs")
    public SaveSuburbResponse saveSuburbs(@Valid @RequestBody List<SuburbRequest> suburbRequestList) throws InvalidSuburbListException {
        List<Suburb> suburbList = suburbRequestList.stream().map(suburbRestConverter::mapToDomain).collect(Collectors.toList());
        var count = saveSuburbsUseCase.execute(suburbList);

        return new SaveSuburbResponse(count);
    }
}
