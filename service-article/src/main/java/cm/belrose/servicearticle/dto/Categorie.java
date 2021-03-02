package cm.belrose.servicearticle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    private Long id;
    private String code;
    private String nom;
}
