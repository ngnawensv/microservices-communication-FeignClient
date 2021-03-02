package cm.belrose.servicearticle.controllers;

import cm.belrose.servicearticle.dto.Categorie;
import cm.belrose.servicearticle.dto.ResponseTemplate;
import cm.belrose.servicearticle.model.Article;
import cm.belrose.servicearticle.proxy.ProxyCategorieService;
import cm.belrose.servicearticle.repository.ArticleRepository;
import cm.belrose.servicearticle.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ProxyCategorieService proxyCategorieService;

    @GetMapping("/articles/test")
    public String index(){
        return articleService.indexCategorie();
    }

    @PostMapping("/articles")
    public Article saveArticle(@RequestBody Article article){
        log.info("Inside the saveArticle method of ArticleController");
        return articleService.saveArticle(article);
    }

    @GetMapping("/articles/{id}")
    public ResponseTemplate findArticleById(@PathVariable("id") Long articleId){
        ResponseTemplate rt = new ResponseTemplate();
        Article art=articleRepository.findById(articleId).get();
        log.info("Article : "+art);
        Categorie cat= proxyCategorieService.findCategorieById(art.getCategorieId());
        log.info("Categorie : "+cat);
        rt.setArticle(art);
        rt.setCategorie(cat);
        log.info("Article avec categorie : "+rt);
        return rt;
    }


    @GetMapping("/articles")
    public List<ResponseTemplate> getAllArticles() {
        return articleService.getAllArticleWithCategorie();

    }

    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return articleService.getAllCategorie();

    }
}
