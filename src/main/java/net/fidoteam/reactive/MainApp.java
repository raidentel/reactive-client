package net.fidoteam.reactive;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.fidoteam.reactive.controller.MainController;
import net.fidoteam.reactive.view.BasicView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = {"net.fidoteam.reactive", "net.fidoteam.reactive.core"},
        basePackageClasses = {BasicView.class})
@EnableAutoConfiguration
@SpringBootApplication
@EnableFeignClients
public class MainApp extends MobileApplication {

    private ConfigurableApplicationContext context;

    @Autowired
    private MainController controller;

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }


    @Override
    public void init() {
        context = SpringApplication.run(MainApp.class);
        final BasicView basicView = context.getBean(BasicView.class);
        addViewFactory(HOME_VIEW, basicView);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.AMBER.assignTo(scene);
        ((Stage) scene.getWindow()).getIcons().add(new Image(MainApp.class.getResourceAsStream("/icon.png")));
    }

    @Override
    public void stop() {
        Platform.exit();
        context.stop();
    }
}
