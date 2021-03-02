package cm.belrose.servicearticle.proxy;

import cm.belrose.servicearticle.dto.Categorie;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-categorie") //specification du service  à appelé
//@RibbonClient(name="service-categorie")
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
