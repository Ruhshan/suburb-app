package xyx.ruhshan.suburb.infrastructure.web.impl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public abstract class AbstractController {
}
