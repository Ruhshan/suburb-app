package xyx.ruhshan.suburb.core.location.usecase;

import java.util.List;

public class CountCharactersInStringListUseCaseImpl implements CountCharactersInStringListUseCase {

    @Override
    public Integer execute(List<String> stringList) {
        return stringList.stream().mapToInt(String::length).sum();
    }
}
