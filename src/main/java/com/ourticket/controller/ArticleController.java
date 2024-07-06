package com.ourticket.controller;

import com.ourticket.model.Article;
import com.ourticket.repository.ArticleRepository;
import com.ourticket.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/create")
    public Article create(@RequestBody Article article){

        return articleService.creer(article);
    }

    @GetMapping("/read")
    public List<Article> read(){
        return articleService.lire();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Article article) {
        Article article1 = articleService.modifier(id, article);
        if (article1 != null) {

            return ResponseEntity.ok(article1);
        } else {
            return ResponseEntity.status(NOT_FOUND)
                    .body("Aucun!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return articleService.supprimer(id);
    }
}


