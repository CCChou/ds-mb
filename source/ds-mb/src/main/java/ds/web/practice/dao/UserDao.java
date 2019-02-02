package ds.web.practice.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ds.web.practice.bean.UserBean;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public UserBean findByAccount(String account) {
		return sessionFactory.getCurrentSession().createQuery("FROM UserBean WHERE account = :account", UserBean.class)
				.setParameter("account", account).uniqueResult();
	}

	public void create(UserBean userBean) {
		sessionFactory.getCurrentSession().save(userBean);
	}

	// @TODO not implemented
	public boolean updateUser(UserBean userBean) {
		return false;
	}
}
