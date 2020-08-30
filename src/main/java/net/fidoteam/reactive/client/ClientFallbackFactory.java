package net.fidoteam.reactive.client;


import feign.hystrix.FallbackFactory;
import net.fidoteam.reactive.model.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ClientFallbackFactory implements FallbackFactory<ResponseVo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientFallbackFactory.class);


    @Override
    public ResponseVo create(Throwable cause) {
        return null;
    }
}
