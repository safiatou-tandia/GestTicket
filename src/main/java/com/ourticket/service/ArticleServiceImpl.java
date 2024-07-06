package com.ourticket.service;

import com.ourticket.model.Article;
import com.ourticket.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    @Override
    public Article creer(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> lire() {
        return articleRepository.findAll();
    }

    @Override
    public Article modifier(Long id, Article article) {
        Optional<Article> article1 = articleRepository.findById(id);
        if (article1.isPresent()){
            Article a = article1.get();
            a.setTitre(article.getTitre());
            a.setContenu(article.getContenu());
            a.setDateCreation(article.getDateCreation());
            return articleRepository.save(a);
        }
        else {
            System.out.println("Aucun !! ");
            return null;
        }
    }


    @Override
    public String supprimer(Long id) {
       articleRepository.deleteById(id);
        return "Article supprimé!";

    }
}

