package ds.web.practice.service;

import ds.web.practice.dto.ArticleDto;
import ds.web.practice.entity.Article;
import ds.web.practice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

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

    }

    public void update(int id, ArticleDto form) {

    }

    public void delete(int id) {
        articleRepository.deleteById(id);
    }
}
