package net.fidoteam.reactive;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.fidoteam.reactive.view.BasicView;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(
        basePackages = {"net.fidoteam.reactive", "net.fidoteam.reactive.core"},
        basePackageClasses = {BasicView.class})
@SpringBootApplication
@EnableFeignClients
public class MainApp extends MobileApplication {

    private ConfigurableApplicationContext context;


    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }


    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.context = new SpringApplicationBuilder().sources(MainApp.class).run(args);
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
