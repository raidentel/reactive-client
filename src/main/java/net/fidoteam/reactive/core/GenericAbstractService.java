package net.fidoteam.reactive.core;

import com.google.common.collect.Lists;
import net.fidoteam.reactive.client.GenericAbstractClient;
import net.fidoteam.reactive.model.CatEntity;
import net.fidoteam.reactive.model.ResponseVo;
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
