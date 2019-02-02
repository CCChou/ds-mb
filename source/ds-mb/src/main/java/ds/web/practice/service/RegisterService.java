package ds.web.practice.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ds.web.practice.bean.UserBean;
import ds.web.practice.dao.UserDao;

@Service
public class RegisterService {
	@Resource
	private UserDao userDao;

	@Transactional
	public boolean checkAccount(String account) {
		UserBean userBean = userDao.findByAccount(account);

		if (userBean == null) {
			return true;
		}

		return false;
	}

	@Transactional
	public void register(String account, String password) {
		UserBean userBean = new UserBean(account, new BCryptPasswordEncoder().encode(password));
		userDao.create(userBean);
	}
}
