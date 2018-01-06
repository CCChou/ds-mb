package ds.web.practice.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ds.web.practice.dao.ArticleDao;

@Service
public class PostService {
	@Resource
	private ArticleDao articleDao;
	
	public void postNewArticle(String account, String title, String content) {
		articleDao.create(account, title, content);
	}
}
