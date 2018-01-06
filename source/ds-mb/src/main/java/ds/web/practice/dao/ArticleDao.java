package ds.web.practice.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ds.web.practice.bean.ArticleBean;

@Repository
public class ArticleDao {
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void create(String account, String title, String content) {
		sessionFactory.getCurrentSession().save(new ArticleBean(account, title, content));
	}
	
	public ArticleBean findById(String id) {
		return null;
	}
	
	// FIXME not find all, should be a period
	public List<String> findAll() {
		return null;
	}
}
