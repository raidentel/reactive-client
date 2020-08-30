package org.gluonhq.reactive.core;

import org.gluonhq.reactive.model.CatEntity;

import java.util.List;

public interface IGenericService {
    List<CatEntity> getAll();
}
