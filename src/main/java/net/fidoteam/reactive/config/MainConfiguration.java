package net.fidoteam.reactive.config;

import net.fidoteam.reactive.view.BasicView;
import net.fidoteam.reactive.core.GenericAbstractService;
import net.fidoteam.reactive.core.IGenericService;
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
