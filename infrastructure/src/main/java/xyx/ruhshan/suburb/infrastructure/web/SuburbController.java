package xyx.ruhshan.suburb.infrastructure.web;

import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;
import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;
import xyx.ruhshan.suburb.infrastructure.web.response.SaveSuburbResponse;

import java.util.List;

public interface SuburbController {
    SaveSuburbResponse saveSuburbs(List<SuburbRequest> suburbRequestList) throws InvalidSuburbListException;
}
