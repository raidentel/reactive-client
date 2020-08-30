package net.fidoteam.reactive.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseVo {

    private List<CatEntity> images;
}
