package xyx.ruhshan.suburb.infrastructure.web;

import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;

import java.util.List;

public interface SuburbController {
    void saveSuburbs(List<SuburbRequest> suburbRequestList);
}
