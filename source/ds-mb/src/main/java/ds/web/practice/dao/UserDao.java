package ds.web.practice.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ds.web.practice.bean.UserBean;

@Repository
public class UserDao {
    @Resource
    private SessionFactory sessionFactory;
    
    public UserBean getUserInfo(String account) {
        return sessionFactory.getCurrentSession().get(UserBean.class, "dennis");
    }
}
