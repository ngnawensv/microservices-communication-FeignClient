package cm.belrose.servicecategorie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author  Ngnawen Samuel
 * @since  23/01/2021 21:48:00
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code_categorie")
    private String code;

    @Column(name = "nom_categorie")
    private String nom;

}
