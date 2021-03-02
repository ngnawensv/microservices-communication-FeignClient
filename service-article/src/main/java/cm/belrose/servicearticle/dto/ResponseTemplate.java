package cm.belrose.servicearticle.dto;

import cm.belrose.servicearticle.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
    private Article article;
    private Categorie categorie;
}
