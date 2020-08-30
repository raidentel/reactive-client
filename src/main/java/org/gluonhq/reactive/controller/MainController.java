package org.gluonhq.reactive.controller;

import javafx.scene.Scene;
import lombok.Data;
import org.gluonhq.reactive.core.IGenericService;
import org.gluonhq.reactive.model.CatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class MainController {

    @Autowired
    private IGenericService service;


    public List<CatEntity> showView() {
        return service.getAll();
    }


}
