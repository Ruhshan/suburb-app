package xyx.ruhshan.suburb.infrastructure.web.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyx.ruhshan.suburb.infrastructure.web.SuburbController;
import xyx.ruhshan.suburb.infrastructure.web.request.SuburbRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SuburbControllerImpl extends AbstractController implements SuburbController  {
    @Override
    @PostMapping("/suburbs")
    public void saveSuburbs(@Valid @RequestBody List<SuburbRequest> suburbRequestList) {
        System.out.println("ok");
    }
}
