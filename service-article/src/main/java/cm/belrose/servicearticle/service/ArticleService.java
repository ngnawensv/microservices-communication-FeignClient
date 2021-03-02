package cm.belrose.servicearticle.service;

import cm.belrose.servicearticle.dto.Categorie;
import cm.belrose.servicearticle.dto.ResponseTemplate;
import cm.belrose.servicearticle.model.Article;
import cm.belrose.servicearticle.proxy.ProxyCategorieService;
import cm.belrose.servicearticle.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
   private ProxyCategorieService proxyCategorieService;

    public String indexCategorie(){
        return proxyCategorieService.indexCategorie();
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Categorie> getAllCategorie() {
        return proxyCategorieService.listeDesCategories();
    }

    public Categorie findCategorieById1(Long idCategorie) {
        return proxyCategorieService.findCategorieById(idCategorie);
    }

   /* public ResponseTemplate findArticleById(Long articleId) {
        ResponseTemplate rt = new ResponseTemplate();
        Article art=articleRepository.findById(articleId).get();
        log.info("Article : "+art);
        Categorie cat= proxyCategorieService.findCategorieById(art.getId());
        log.info("Categorie : "+cat);
        rt.setArticle(art);
        rt.setCategorie(cat);
        log.info("Article avec categorie : "+rt);
        return rt;
    }*/

    public List<ResponseTemplate> getAllArticleWithCategorie() {
        List<ResponseTemplate> responseTemplates=new ArrayList<>();
        List<Article> articleList=articleRepository.findAll();
        articleList.forEach(article -> {
            ResponseTemplate rt = new ResponseTemplate();
            Categorie cat1= proxyCategorieService.findCategorieById(article.getId());
            rt.setArticle(article);
            rt.setCategorie(cat1);
            responseTemplates.add(rt);
        });
        return  responseTemplates;
    }


}
