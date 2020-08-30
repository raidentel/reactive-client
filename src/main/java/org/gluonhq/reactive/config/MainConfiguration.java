package org.gluonhq.reactive.config;

import org.gluonhq.reactive.BasicView;
import org.gluonhq.reactive.controller.MainController;
import org.gluonhq.reactive.core.GenericAbstractService;
import org.gluonhq.reactive.core.IGenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public IGenericService service() {
        return new GenericAbstractService();
    }

    @Bean
    public BasicView basicView() {
        return new BasicView();
    }


}
