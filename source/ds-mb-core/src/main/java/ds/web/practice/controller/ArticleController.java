package ds.web.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable int id) {
        return "";
    }

    @GetMapping("/articles")
    public String listArticles() {
        return "";
    }

    @PostMapping("")
    public void saveArticle() {

    }

    @PutMapping("")
    public void updateArticle() {

    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable int id) {

    }

}
