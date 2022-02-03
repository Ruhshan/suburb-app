package xyx.ruhshan.suburb.core.location.usecase;

import xyx.ruhshan.suburb.core.location.Suburb;

import java.util.List;

public interface FetchSuburbsByPostCodeRange {
    List<Suburb> execute(String postCodeFrom, String postCodeTo);
}
