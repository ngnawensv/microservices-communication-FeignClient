package cm.belrose.servicecategorie.service;

import cm.belrose.servicecategorie.model.Categorie;
import cm.belrose.servicecategorie.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie findCategorieById(Long id) {
        return categorieRepository.findById(id).get();
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
}
