package ds.web.practice.service;

import ds.web.practice.entity.Article;
import ds.web.practice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {

    @Autowired
    private ArticleRepository articleRepository;

    public boolean hasAuthorization(int userId, int articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(RuntimeException::new);
        return userId == article.getOwner().getId();
    }
}
