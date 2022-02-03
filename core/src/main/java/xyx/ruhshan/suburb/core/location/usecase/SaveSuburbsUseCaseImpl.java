package xyx.ruhshan.suburb.core.location.usecase;

import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;
import xyx.ruhshan.suburb.core.location.ports.SuburbRepositoryService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaveSuburbsUseCaseImpl implements SaveSuburbsUseCase {
    private final SuburbRepositoryService suburbRepositoryService;

    public SaveSuburbsUseCaseImpl(SuburbRepositoryService suburbRepositoryService) {
        this.suburbRepositoryService = suburbRepositoryService;
    }

    @Override
    public void execute(List<Suburb> suburbList) throws InvalidSuburbListException {
        try {
            suburbList.forEach(Suburb::validateSelf);
        }catch (ConstraintViolationException e) {
            throw new InvalidSuburbListException(e.getMessage());
        }

        suburbRepositoryService.saveSuburbs(suburbList);


    }
}
