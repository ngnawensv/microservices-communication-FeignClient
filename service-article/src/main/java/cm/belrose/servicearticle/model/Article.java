package cm.belrose.servicearticle.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 *@author  Ngnawen Samuel
 * @Since  Le 23/01/2021
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_article")
    private Long id;
    @Column(name = "nom_article")
    private String nom;
    @Column(name = "prix_achat_article")
    private double prixAchat;
    @Column(name = "prix_vente_article")
    private double prixVente;
    @Column(name = "quantite_article")
    private double quantite;
    @Column(name = "categorie_id")
    private Long categorieId;
}
