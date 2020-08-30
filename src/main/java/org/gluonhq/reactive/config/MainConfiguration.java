package org.gluonhq.reactive.config;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
    public Scene scene() {
        VBox vBox  = new VBox();
        return new Scene(vBox);
    }
}
