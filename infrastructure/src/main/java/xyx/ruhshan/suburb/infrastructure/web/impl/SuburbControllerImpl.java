package xyx.ruhshan.suburb.infrastructure.web.impl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;
import xyx.ruhshan.suburb.core.location.usecase.CountCharactersInStringListUseCase;
import xyx.ruhshan.suburb.core.location.usecase.FetchSuburbsByPostCodeRangeUseCase;
import xyx.ruhshan.suburb.core.location.usecase.SaveSuburbsUseCase;
import xyx.ruhshan.suburb.infrastructure.web.SuburbController;
import xyx.ruhshan.suburb.infrastructure.web.converter.SuburbRestConverter;
import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;
import xyx.ruhshan.suburb.infrastructure.web.response.FetchSuburbResponse;
import xyx.ruhshan.suburb.infrastructure.web.response.SaveSuburbResponse;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SuburbControllerImpl extends AbstractController implements SuburbController  {
    private final SaveSuburbsUseCase saveSuburbsUseCase;
    private final SuburbRestConverter suburbRestConverter;
    private final FetchSuburbsByPostCodeRangeUseCase fetchSuburbsByPostCodeRangeUseCase;
    private final CountCharactersInStringListUseCase countCharactersInStringListUseCase;

    public SuburbControllerImpl(SaveSuburbsUseCase saveSuburbsUseCase, SuburbRestConverter suburbRestConverter,
                                FetchSuburbsByPostCodeRangeUseCase fetchSuburbsByPostCodeRangeUseCase, CountCharactersInStringListUseCase countCharactersInStringListUseCase) {
        this.saveSuburbsUseCase = saveSuburbsUseCase;
        this.suburbRestConverter = suburbRestConverter;
        this.fetchSuburbsByPostCodeRangeUseCase = fetchSuburbsByPostCodeRangeUseCase;
        this.countCharactersInStringListUseCase = countCharactersInStringListUseCase;
    }

    @Override
    @PostMapping("/suburbs")
    public SaveSuburbResponse saveSuburbs(@Valid @RequestBody List<SuburbRequest> suburbRequestList) throws InvalidSuburbListException {
        List<Suburb> suburbList = suburbRequestList.stream().map(suburbRestConverter::mapToDomain).collect(Collectors.toList());
        var count = saveSuburbsUseCase.execute(suburbList);

        return new SaveSuburbResponse(count);
    }

    @Override
    @GetMapping("/suburbs")
    public FetchSuburbResponse fetchSuburbsByPostCodeRange(@RequestParam Integer start, @RequestParam Integer end) {
        List<String> suburbList = fetchSuburbsByPostCodeRangeUseCase.execute(start, end);
        var count = countCharactersInStringListUseCase.execute(suburbList);
        return new FetchSuburbResponse(suburbList, count);
    }
}
