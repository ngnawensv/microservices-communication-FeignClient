package cm.belrose.servicearticle.config;


import cm.belrose.servicearticle.model.Article;
import cm.belrose.servicearticle.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * Le 16/11/2020 à 09heures
 *
 * @author Ngnawen Samuel
 * <p>
 * Cette classe permet d'initialiser ma base de données avec quelques articles
 */
@Component
public class Initializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Initializer.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<Article> articles = new ArrayList<>();
        Article article1 = new Article(1l,"nom_art1", 1000, 1500, 10,17l);
        Article article2 = new Article(2l,"nom_art2", 500, 1000, 15,17l);
        Article article3 = new Article(3l,"nom_art3", 2500, 2575, 18,18l);
        Article article4 = new Article(4l,"nom_art4", 450, 600, 100,20l);
        Article article5 = new Article(5l,"nom_art5", 100, 200, 55,20l);
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        Consumer<Article> consumer = (article -> {
            List<Article> artilces_db = articleRepository.findAll();
            if (artilces_db.size() < 5) {
                articleRepository.save(article);
                logger.info("Article save ===> " + article.getNom());
            }
            logger.info("Article " + article.getNom() + " already exist");
        });
        articles.forEach(consumer);
    }
}
