package net.fidoteam.reactive.model;

import lombok.*;

import java.io.Serializable;

/**
 * Represent cat picture model class.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CatEntity implements Serializable {

    private static final long serialVersionUID = 6398676189025643407L;
    private String id;
    private String url;
    private boolean voted;
    private Integer score = 0;

}
