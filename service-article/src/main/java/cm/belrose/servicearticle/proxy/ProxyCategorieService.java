package cm.belrose.servicearticle.proxy;

import cm.belrose.servicearticle.dto.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "service-categorie") //specification du service  à appelé
public interface ProxyCategorieService {

    @GetMapping(value = "/categories/{id}")
    Categorie findCategorieById(@PathVariable("id") Long id);

    /*@GetMapping(name = "/categories/")
    List<Categorie> findAll();*/

    @GetMapping(value ="/categories/test")
    String indexCategorie();

    @GetMapping(value ="/categories")
    List<Categorie> listeDesCategories();

}
