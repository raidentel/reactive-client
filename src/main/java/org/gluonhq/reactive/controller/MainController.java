package org.gluonhq.reactive.controller;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.TextArea;
import javafx.scene.Scene;
import lombok.Data;
import org.gluonhq.reactive.BasicView;
import org.gluonhq.reactive.core.IGenericService;
import org.gluonhq.reactive.model.CatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class MainController extends MobileApplication {

    @Autowired
    private IGenericService service;

    @Autowired
    private Scene scene;


    public void showView() {
        final List<CatEntity> list = service.getAll();
        TextArea textArea = new TextArea(list.get(0).getUrl());

    }


}
