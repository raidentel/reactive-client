package org.gluonhq.reactive.client;

import org.gluonhq.reactive.config.ClientConfig;
import org.gluonhq.reactive.model.ResponseVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cat",
        configuration = ClientConfig.class,
        fallbackFactory = ClientFallbackFactory.class,
        url = "https://latelier.co")
public interface GenericAbstractClient {


    @RequestMapping(value="/data/cats.json",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseVo getAll();


}
