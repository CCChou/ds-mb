package ds.web.practice.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ds.web.practice.bean.UserBean;

@Repository
public class UserDao {
    @Resource
    private SessionFactory sessionFactory;

    public UserBean findUserByAccount(String account) {
        return sessionFactory.getCurrentSession().get(UserBean.class, account);
    }

    public void create(UserBean userBean) {
        sessionFactory.getCurrentSession().save(userBean);
    }

    // @TODO not implemented
    public boolean updateUser(UserBean userBean) {
        return false;
    }
}
