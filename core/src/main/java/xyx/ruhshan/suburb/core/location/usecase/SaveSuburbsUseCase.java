package xyx.ruhshan.suburb.core.location.usecase;

import xyx.ruhshan.suburb.core.location.domain.Suburb;
import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;

import java.util.List;

public interface SaveSuburbsUseCase {
    void execute(List<Suburb> suburbList) throws InvalidSuburbListException;
}
