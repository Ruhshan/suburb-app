package xyx.ruhshan.suburb.core.location.usecase;

import java.util.List;

public interface FetchSuburbsByPostCodeRangeUseCase {
    List<String> execute(Integer postCodeFrom, Integer postCodeTo);
}
