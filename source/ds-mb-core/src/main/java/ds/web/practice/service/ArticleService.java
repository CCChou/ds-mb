package ds.web.practice.service;

import ds.web.practice.dto.ArticleDto;
import ds.web.practice.entity.Article;
import ds.web.practice.repository.ArticleRepository;
import ds.web.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    public  ArticleDto query(int id) {
        Article article = articleRepository.findById(id).orElseThrow(RuntimeException::new);
        return toDto(article);
    }

    private ArticleDto toDto(Article article) {
        ArticleDto dto = new ArticleDto();
        dto.setId(article.getId());
        dto.setContent(article.getContent());
        dto.setCreateTime(article.getCreateTime());
        dto.setLastUpdateTime(article.getLastUpdateTime());
        dto.setOwnerName(article.getOwner().getName());
        dto.setTitle(article.getTitle());
        return dto;
    }

    public List<ArticleDto> list() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void save(ArticleDto form) {
        Article article = new Article();
        article.setContent(form.getContent());
        article.setCreateTime(Instant.now());
        article.setLastUpdateTime(Instant.now());
        article.setOwner(userRepository.findById(form.getOwnerId()).orElseThrow(RuntimeException::new));
        article.setTitle(form.getTitle());
        articleRepository.save(article);
    }

    public void update(int id, ArticleDto form) {
        Article article = articleRepository.findById(id).orElseThrow(RuntimeException::new);
        article.setContent(form.getContent());
        article.setLastUpdateTime(Instant.now());
        article.setTitle(form.getTitle());
        articleRepository.save(article);
    }

    public void delete(int id) {
        articleRepository.deleteById(id);
    }
}
