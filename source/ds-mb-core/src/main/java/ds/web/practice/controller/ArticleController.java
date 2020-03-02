package ds.web.practice.controller;

import ds.web.practice.dto.ArticleDto;
import ds.web.practice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public ArticleDto query(@PathVariable int id) {
        return articleService.query(id);
    }

    @GetMapping("/articles")
    public List<ArticleDto> listArticles() {
        return articleService.list();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/articles")
    public void saveArticle(ArticleDto form) {
        articleService.save(form);
    }

    // TODO hasPermission to update document
    // for now suppose that the admin can not update
    @PutMapping("/articles/{id}")
    public void updateArticle(@PathVariable int id, ArticleDto form) {
        articleService.update(id, form);
    }

    // TODO hasPermission to delete document
    // for now suppose that the admin can delete
    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.delete(id);
    }
}
