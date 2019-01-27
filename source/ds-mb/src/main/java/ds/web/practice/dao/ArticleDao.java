package ds.web.practice.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Transactional
    public ArticleBean findById(int id) {
        return sessionFactory.getCurrentSession().get(ArticleBean.class, id);
    }

    @Transactional
    @SuppressWarnings("rawtypes")
    public long findCount() {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from ArticleBean");
        return (long) query.uniqueResult();
    }

    @Transactional
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<ArticleBean> findByRange(int start, int limit) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ArticleBean order by date desc").setFirstResult(start).setMaxResults(limit);
        return query.list();
    }

    @Transactional
    @SuppressWarnings("rawtypes")
    public long findCountByTitleCondition(String condition) {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from ArticleBean where title like ?").setParameter(0, "%" + condition + "%");
        return (long) query.uniqueResult();
    }

    @Transactional
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<ArticleBean> findTitleRangeByCondition(String condition, int start, int limit) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ArticleBean where title like ? order by date desc").setParameter(0, "%" + condition + "%").setFirstResult(start)
                .setMaxResults(limit);
        return query.list();
    }

}