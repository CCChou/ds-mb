package ds.web.practice.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ds.web.practice.bean.UserBean;
import ds.web.practice.dao.ArticleDao;
import ds.web.practice.dao.UserDao;

@Service
public class PostService {
    @Resource
    private ArticleDao articleDao;
    
    @Resource
    private UserDao userDao;

    public void postNewArticle(String account, String title, String content) {
    	UserBean user = userDao.findByAccount(account);
        articleDao.create(user, title, content);
    }
}
