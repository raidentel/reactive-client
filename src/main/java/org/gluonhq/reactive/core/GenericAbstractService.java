package org.gluonhq.reactive.core;

import com.google.common.collect.Lists;
import org.gluonhq.reactive.client.GenericAbstractClient;
import org.gluonhq.reactive.model.CatEntity;
import org.gluonhq.reactive.model.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GenericAbstractService implements IGenericService {

    @Autowired
    private GenericAbstractClient client;


    public List<CatEntity> getAll() {
        final ResponseVo vo = client.getAll();
        return vo != null ? vo.getImages() : Lists.newArrayList(
                CatEntity.builder().url("pas de reponse").build());
    }

}
