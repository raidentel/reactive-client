package net.fidoteam.reactive.controller;

import lombok.Data;
import net.fidoteam.reactive.core.IGenericService;
import net.fidoteam.reactive.model.CatEntity;
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
