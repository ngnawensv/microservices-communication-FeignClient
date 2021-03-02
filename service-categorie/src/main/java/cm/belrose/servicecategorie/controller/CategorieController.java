package cm.belrose.servicecategorie.controller;

import cm.belrose.servicecategorie.model.Categorie;
import cm.belrose.servicecategorie.service.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categories/test")
    public String indexCategorie(){
        return "Je suis dans service-catégorie";
    }

    @GetMapping("/categories/{id}")
    public Categorie findCategorieById(@PathVariable("id") Long id){
        log.info("Inside the findCategorie................");
        return categorieService.findCategorieById(id);
    }

    @GetMapping("/categories")
    public List<Categorie> listeDesCategories(){
        List<Categorie> categories=categorieService.findAll();
        log.info("I am inside the microservice catégorie....................");
        categories.forEach(System.out::println);
        return categories;
    }
}
